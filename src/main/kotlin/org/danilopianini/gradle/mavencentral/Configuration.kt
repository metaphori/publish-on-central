package org.danilopianini.gradle.mavencentral

import org.danilopianini.gradle.mavencentral.ProjectExtensions.registerTaskIfNeeded
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.tasks.PublishToMavenRepository
import org.gradle.api.publish.plugins.PublishingPlugin
import org.gradle.configurationcache.extensions.capitalized
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.the
import org.gradle.kotlin.dsl.withType
import org.gradle.plugins.signing.Sign
import org.gradle.plugins.signing.SigningExtension
import java.net.URI

internal inline fun <reified T> Project.propertyWithDefault(default: T?): Property<T> =
    objects.property(T::class.java).apply { convention(default) }

internal inline fun <reified T> Project.propertyWithDefaultProvider(noinline default: () -> T?): Property<T> =
    objects.property(T::class.java).apply { convention(provider(default)) }

/**
 * Configures a [MavenPublication] for publication on Maven Central, adding the following.
 * - appropriate pom.xml configuration
 * - a main jar file
 * - a source jar file
 * - a javadoc jar file
 */
fun MavenPublication.configureForMavenCentral(extension: PublishOnCentralExtension) {
    configurePomForMavenCentral(extension)
    val project = extension.project
    // Signing
    findSigningTaskIn(project) ?: project.configure<SigningExtension> {
        sign(this@configureForMavenCentral)
    }
}

/**
 * Configures the pom.xml file of a [MavenPublication] with the information specified in this configuration.
 */
fun MavenPublication.configurePomForMavenCentral(extension: PublishOnCentralExtension) {
    pom { pom ->
        with(pom) {
            name.set(extension.projectLongName)
            description.set(extension.projectDescription)
            url.set(extension.projectUrl)
            licenses {
                it.license { license ->
                    license.name.set(extension.licenseName)
                    license.url.set(extension.licenseUrl)
                }
            }
            scm { scm ->
                scm.url.set(extension.projectUrl)
                scm.connection.set(extension.scmConnection)
                scm.developerConnection.set(extension.scmConnection)
            }
        }
    }
}

/**
 * Reifies this repository setup onto every [PublishingExtension] configuration of the provided [Project].
 */
fun Project.configureRepository(repoToConfigure: Repository) {
    extensions.configure(PublishingExtension::class) { publishing ->
        publishing.repositories { repository ->
            repository.maven { mavenArtifactRepository ->
                mavenArtifactRepository.name = repoToConfigure.name
                mavenArtifactRepository.url = URI(repoToConfigure.url)
                mavenArtifactRepository.credentials { credentials ->
                    credentials.username = repoToConfigure.user.orNull
                    credentials.password = repoToConfigure.password.orNull
                }
                tasks.withType(PublishToMavenRepository::class) {
                    if (it.repository == mavenArtifactRepository) {
                        it.doFirst {
                            warnIfCredentialsAreMissing(repoToConfigure)
                        }
                    }
                }
            }
        }
    }
    if (repoToConfigure.nexusUrl != null) {
        configureNexusRepository(repoToConfigure, repoToConfigure.nexusUrl)
    }
}

private fun Project.configureNexusRepository(repoToConfigure: Repository, nexusUrl: String) {
    val nexusClient = rootProject.registerTaskIfNeeded<InitializeNexusClient>(
        "createNexusClientFor${repoToConfigure.name}",
        repoToConfigure,
        nexusUrl,
    ) as InitializeNexusClient
    val createStagingRepository = rootProject.registerTaskIfNeeded<DefaultTask>(
        "createStagingRepositoryOn${repoToConfigure.name}"
    ) {
        dependsOn(nexusClient)
        doLast {
            rootProject.warnIfCredentialsAreMissing(repoToConfigure)
            nexusClient.nexusClient.repoUrl // triggers the initialization of a repository
        }
        group = PublishingPlugin.PUBLISH_TASK_GROUP
        description = "Creates a new Nexus staging repository on ${repoToConfigure.name}."
    }
    val uploadAllPublications = tasks.register("uploadAllPublicationsTo${repoToConfigure.name}Nexus") {
        it.dependsOn(createStagingRepository)
        it.group = PublishingPlugin.PUBLISH_TASK_GROUP
        it.description = "Uploads all publications to a staging repository on ${repoToConfigure.name}."
    }
    val closeStagingRepository = rootProject.registerTaskIfNeeded<DefaultTask>(
        "closeStagingRepositoryOn${repoToConfigure.name}"
    ) {
        doLast { nexusClient.nexusClient.close() }
        dependsOn(createStagingRepository)
        mustRunAfter(uploadAllPublications)
        group = PublishingPlugin.PUBLISH_TASK_GROUP
        description = "Closes the Nexus repository on ${repoToConfigure.name}."
    }
    rootProject.registerTaskIfNeeded<DefaultTask>("releaseStagingRepositoryOn${repoToConfigure.name}") {
        doLast { nexusClient.nexusClient.release() }
        dependsOn(closeStagingRepository)
        group = PublishingPlugin.PUBLISH_TASK_GROUP
        description = "Releases the Nexus repo on ${repoToConfigure.name}."
    }
    the<PublishingExtension>().publications.withType<MavenPublication>().configureEach { publication ->
        val publicationName = publication.name.replaceFirstChar(Char::titlecase)
        project.tasks.register<PublishToMavenRepository>(
            "upload${publicationName}To${repoToConfigure.name}Nexus",
        ).configure { uploadTask ->
            uploadTask.repository = project.repositories.maven { repo ->
                repo.name = repoToConfigure.name
                repo.url = project.uri(repoToConfigure.url)
                repo.credentials {
                    it.username = repoToConfigure.user.orNull
                    it.password = repoToConfigure.password.orNull
                }
            }
            uploadTask.publication = publication
            publication.findSigningTaskIn(project).forEach {
                uploadTask.dependsOn(it)
            }
            uploadTask.dependsOn(createStagingRepository)
            uploadAllPublications.get().dependsOn(uploadTask)
            closeStagingRepository.mustRunAfter(uploadTask)
            uploadTask.doFirst {
                warnIfCredentialsAreMissing(repoToConfigure)
                uploadTask.repository.url = nexusClient.nexusClient.repoUrl
            }
            uploadTask.group = PublishingPlugin.PUBLISH_TASK_GROUP
            uploadTask.description = "Uploads the $publicationName publication " +
                "to a staging repository on ${repoToConfigure.name}."
        }
    }
}

private fun Project.warnIfCredentialsAreMissing(repository: Repository) {
    if (repository.user.orNull == null) {
        logger.warn(
            "No username configured for repository {} at {}.",
            repository.name,
            repository.url,
        )
    }
    if (repository.password.orNull == null) {
        logger.warn(
            "No password configured for user {} on repository {} at {}.",
            repository.user.orNull,
            repository.name,
            repository.url,
        )
    }
}

/**
 * Returns the signign tasks registered for the [MavenPublication] in the current [project].
 */
fun MavenPublication.findSigningTaskIn(project: Project) =
    project.tasks.withType<Sign>().matching { it.name.endsWith("sign${name.capitalized()}Publication") }
