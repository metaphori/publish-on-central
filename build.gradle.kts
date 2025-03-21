import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `java-gradle-plugin`
    alias(libs.plugins.dokka)
    alias(libs.plugins.gitSemVer)
    alias(libs.plugins.gradlePluginPublish)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.publishOnCentral)
    alias(libs.plugins.multiJvmTesting)
    alias(libs.plugins.taskTree)
}

gitSemVer {
    buildMetadataSeparator.set("-")
}

group = "org.danilopianini"
val projectId = "$group.$name"
val fullName = "Gradle Publish On Maven Central Plugin"
val websiteUrl = "https://github.com/DanySK/$name"
val projectDetails = "A Plugin for easily publishing artifacts on Maven Central"
val pluginImplementationClass = "org.danilopianini.gradle.mavencentral.PublishOnCentral"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

multiJvm {
    maximumSupportedJvmVersion.set(latestJavaSupportedByGradle)
}

dependencies {
    api(kotlin("stdlib"))
    api(gradleApi())
    api(gradleKotlinDsl())
    api(libs.nexus.publish)
    testImplementation(gradleTestKit())
    testImplementation(libs.bundles.kotlin.testing)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        allWarningsAsErrors = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
        showCauses = true
        showStackTraces = true
        events(*org.gradle.api.tasks.testing.logging.TestLogEvent.values())
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

pluginBundle {
    website = websiteUrl
    vcsUrl = websiteUrl
    tags = listOf("maven", "maven central", "ossrh", "central", "publish")
}

gradlePlugin {
    plugins {
        create("PublishOnCentralPlugin") {
            id = projectId
            displayName = fullName
            description = projectDetails
            implementationClass = pluginImplementationClass
        }
    }
}

publishOnCentral {
    projectDescription.set(projectDetails)
    projectLongName.set(fullName)
    projectUrl.set(websiteUrl)
    scmConnection.set("git:git@github.com:DanySK/$name")
    repository("https://maven.pkg.github.com/DanySK/$name".toLowerCase()) {
        user.set("danysk")
        password.set(System.getenv("GITHUB_TOKEN"))
    }
    publishing {
        publications {
            withType<MavenPublication> {
                pom {
                    developers {
                        developer {
                            name.set("Danilo Pianini")
                            email.set("danilo.pianini@gmail.com")
                            url.set("http://www.danilopianini.org/")
                        }
                    }
                }
            }
        }
    }
}

if (System.getenv("CI") == true.toString()) {
    signing {
        val signingKey: String? by project
        val signingPassword: String? by project
        useInMemoryPgpKeys(signingKey, signingPassword)
    }
}

val registerCredentials = tasks.register("registerGradlePluginPortalCredentials") {
    doLast {
        listOf("gradle.publish.key", "gradle.publish.secret").forEach {
            if (!(project.hasProperty(it) or System.getenv().containsKey(it))) {
                val bashName = it.toUpperCase().replace(".", "_")
                System.getProperties().setProperty(
                    it,
                    System.getenv(bashName) ?: throw IllegalStateException(
                        "Property $it is unset and environment variable $bashName unavailable"
                    )
                )
            }
        }
    }
}

tasks.publishPlugins {
    dependsOn(registerCredentials)
}
