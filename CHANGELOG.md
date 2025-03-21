## [2.0.0](https://github.com/DanySK/publish-on-central/compare/1.0.2...2.0.0) (2022-06-30)


### ⚠ BREAKING CHANGES

* enable automatic configuration of POM and signing for all MavenPublications (can be disabled via autoConfigureAllPublications)
* switch the default publication name to [SoftwareComponentName]OSSRH, as it is easier to distinguish by name (accessing other properties finalizes the publications)
* do not force jar packaging when configuring a pom
* **nexus:** multiprojects are now uploaded correctly and stored in a single Nexus repository

### Features

* enable automatic configuration of POM and signing for all MavenPublications (can be disabled via autoConfigureAllPublications) ([c65838c](https://github.com/DanySK/publish-on-central/commit/c65838c2aef6e742fdd1cd7d3242b18c6d0a0d8c))


### Bug Fixes

* always generate signign task for generated publications ([d27ccca](https://github.com/DanySK/publish-on-central/commit/d27ccca91b6d300536f442c44b62295301ffa91f))
* do not force jar packaging when configuring a pom ([6ec8392](https://github.com/DanySK/publish-on-central/commit/6ec839281edbe2166ec6967af1a0a02bc2d96684))
* **nexus:** multiprojects are now uploaded correctly and stored in a single Nexus repository ([16edbb9](https://github.com/DanySK/publish-on-central/commit/16edbb98cff15bff24ac8f1f9cb6099bb40f5244))
* **release:** use a fixed beta version of the plugin for publishing the fixed version of the plugin (will be replaced by the new stable version as soon as the release happens) ([1fe706b](https://github.com/DanySK/publish-on-central/commit/1fe706bb66a91b53084a29ae24ea0b1419d2878c))
* remove debug println ([dea29e9](https://github.com/DanySK/publish-on-central/commit/dea29e94f3e8e50ed4c5e7d9ff08969e634831a8))
* restore multiproject support for Nexus ([f1c3f5b](https://github.com/DanySK/publish-on-central/commit/f1c3f5bbddded0f07daa711daaace4ba0271ef4a))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.dokka to v1.7.0 ([3e4eea0](https://github.com/DanySK/publish-on-central/commit/3e4eea0b9345d4bcef33521363aff833ea190f0f))
* **deps:** update plugin gradlepluginpublish to v1 ([2cb057c](https://github.com/DanySK/publish-on-central/commit/2cb057c86316146393e28a75a2ccf5f723f1ce39))
* **deps:** update plugin publishoncentral to v1 ([0561454](https://github.com/DanySK/publish-on-central/commit/05614544a20c51f1a94fdf3b661634bbc88e1d41))


### Refactoring

* allow access to findSigningTaskIn from the external world ([6928dee](https://github.com/DanySK/publish-on-central/commit/6928deeccfdaf90d0e9ec7ba5dd414b18bd80e18))
* switch the default publication name to [SoftwareComponentName]OSSRH, as it is easier to distinguish by name (accessing other properties finalizes the publications) ([7447e44](https://github.com/DanySK/publish-on-central/commit/7447e442422bd2fdafc4c6ce1f7ec4095724b014))


### Build and continuous integration

* add a test with a dry-deployment of a Kotlin-multiplatform project ([a7e0918](https://github.com/DanySK/publish-on-central/commit/a7e0918a2389dfd0824e6d2537a9f721cedb23f0))
* add external test with an Alchemist dry-deployment ([93d1fe4](https://github.com/DanySK/publish-on-central/commit/93d1fe4da1f5d6aa5fe4d049fe1dbe11cb524928))
* fix the deployment task names ([0d51486](https://github.com/DanySK/publish-on-central/commit/0d51486c5d5acb13a033e287f1488b2cf6646623))
* refer to the latest multiplatform template ([5aebfd1](https://github.com/DanySK/publish-on-central/commit/5aebfd1ed92d460c6df644e8bdf78868e8c89a49))


### Tests

* print the stacktrace on failure ([e48fa3e](https://github.com/DanySK/publish-on-central/commit/e48fa3ea6f7110cbda1cbe57f0ccc46627bc8ba0))
* update tests to use the new publication naming ([50bbe50](https://github.com/DanySK/publish-on-central/commit/50bbe5026c24d05ede2a8709d9f7510960433094))


### Documentation

* add a task dependency graph for a Nexus publication ([4ac98cf](https://github.com/DanySK/publish-on-central/commit/4ac98cfdea69a94f82ab6c0affa9b65bcfa08a71))
* **readme:** document how to use this plugin with Kotlin multiplatform ([49ce8e5](https://github.com/DanySK/publish-on-central/commit/49ce8e5eebf65bd979556922e08cc94099439d3c))

## [1.0.2](https://github.com/DanySK/publish-on-central/compare/1.0.1...1.0.2) (2022-06-17)


### Bug Fixes

* the upload task explicitly depends on the signing task ([c510415](https://github.com/DanySK/publish-on-central/commit/c510415a1da0cce818fb1b4ece1483c3eb959a29))


### Build and continuous integration

* add missing secrets ([868513e](https://github.com/DanySK/publish-on-central/commit/868513e6b7d2b465fb55f0bdfdca580068e82fb9))
* test a dry deployment on branch builds ([2c14d5a](https://github.com/DanySK/publish-on-central/commit/2c14d5a2565cbc82ab0451ed6ad3deebe5c906ec))

## [1.0.1](https://github.com/DanySK/publish-on-central/compare/1.0.0...1.0.1) (2022-06-17)


### Bug Fixes

* remove printlns ([426f5d6](https://github.com/DanySK/publish-on-central/commit/426f5d6f4c395302545832da44a16a2588deab35))

## [1.0.0](https://github.com/DanySK/publish-on-central/compare/0.8.3...1.0.0) (2022-06-17)


### ⚠ BREAKING CHANGES

* rework the Nexus interaction, now multiple publications can be uploaded to the same staging repository before closing and releasing

### Features

* rework the Nexus interaction, now multiple publications can be uploaded to the same staging repository before closing and releasing ([fe725b7](https://github.com/DanySK/publish-on-central/commit/fe725b74f3dc499db417945efc5b266eda21284a))


### Dependency updates

* **deps:** update plugin publishoncentral to v0.8.3 ([b0c6117](https://github.com/DanySK/publish-on-central/commit/b0c6117b9f01c50e729f3d72250e49a1efa5d7e9))


### Tests

* add a test for kotlin multiplatform ([b7c2f2e](https://github.com/DanySK/publish-on-central/commit/b7c2f2ed176c38c0b121c2fa36f8e39e78d87aa9))

## [0.8.3](https://github.com/DanySK/publish-on-central/compare/0.8.2...0.8.3) (2022-06-11)


### Bug Fixes

* prefer the task avoidance API, see [#286](https://github.com/DanySK/publish-on-central/issues/286) ([39ffe05](https://github.com/DanySK/publish-on-central/commit/39ffe05d3c1d82540c2f967dbe4ee1ed8628a56d))
* replace findByName with the lazy configuration ([a2cfac7](https://github.com/DanySK/publish-on-central/commit/a2cfac78da7f15436fe0ccaf2562384f020c55ec))


### Dependency updates

* **deps:** bump semantic-release from 19.0.2 to 19.0.3 ([7ef4f49](https://github.com/DanySK/publish-on-central/commit/7ef4f493e81f1469a870c1449a9d1a25ed641ec0))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.8 ([a5fe1b3](https://github.com/DanySK/publish-on-central/commit/a5fe1b351fd31cf6bfaa5c0b53f6e0bcabb9699f))
* **deps:** update plugin com.gradle.enterprise to v3.10.2 ([055824e](https://github.com/DanySK/publish-on-central/commit/055824e0bc30aad83bd33ce83e8cf111db747fa1))
* **deps:** update plugin kotlin-qa to v0.19.1 ([dae88c7](https://github.com/DanySK/publish-on-central/commit/dae88c7acc62202f225b4a44924f53d6d77fc693))
* **deps:** update plugin multijvmtesting to v0.4.2 ([ab3bd9e](https://github.com/DanySK/publish-on-central/commit/ab3bd9e3c3bc4379822bf5b2c2adfc677026d646))
* **deps:** update plugin multijvmtesting to v0.4.3 ([076a282](https://github.com/DanySK/publish-on-central/commit/076a282255a19ffb984f2b364932037aa70892a9))
* **deps:** update plugin publishoncentral to v0.8.2 ([1dddaee](https://github.com/DanySK/publish-on-central/commit/1dddaeec4183d71b7d9ba3bc5410114d6cb4f545))


### Performance improvements

* replace forEach with configureEach (lazy configuration) ([d615bab](https://github.com/DanySK/publish-on-central/commit/d615babb26ce89cd1893dd17e0eb09e3aa34216f))
* replace whenObjectAdded with configureEach (lazy configuration) ([c5c0cb1](https://github.com/DanySK/publish-on-central/commit/c5c0cb18551a9b83ee768f9ef9e6b1ceb92136f9))


### General maintenance

* fix the source package structure ([1fa9ffb](https://github.com/DanySK/publish-on-central/commit/1fa9ffb655c12406e9a13d6adb76b71ca091ab57))


### Style improvements

* remove unnecessary qualified name ([3859c99](https://github.com/DanySK/publish-on-central/commit/3859c992c26048579788fe6255698ed00bcc7b53))
* switch to org.gradle.kotlin.dsl.withType ([1a291a7](https://github.com/DanySK/publish-on-central/commit/1a291a76ee5adb3beb7ea446e763400bfd87ba0e))


### Tests

* add verification for sources and javadoc jar generation ([02355c4](https://github.com/DanySK/publish-on-central/commit/02355c477b56a82b8c82d581f778f492037f5f02))
* improve the testing framework ([2e73c80](https://github.com/DanySK/publish-on-central/commit/2e73c80b99b1fce31b7abb138b4e2a06a8f45932))
* set a test project name ([c34b6d1](https://github.com/DanySK/publish-on-central/commit/c34b6d1a61315b07a05545bc3da35d8b39b146c5))

## [0.8.2](https://github.com/DanySK/publish-on-central/compare/0.8.1...0.8.2) (2022-06-09)


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin.jvm to v1.7.0 ([1818d03](https://github.com/DanySK/publish-on-central/commit/1818d036be6a83e428df578ce1696d9a4d08fafb))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.0.12 ([bc281b7](https://github.com/DanySK/publish-on-central/commit/bc281b7ec3320032c5148973bde49a06603a02c7))

## [0.8.1](https://github.com/DanySK/publish-on-central/compare/0.8.0...0.8.1) (2022-06-09)


### Bug Fixes

* configure the jar publications only on jar packaging, fixes [#287](https://github.com/DanySK/publish-on-central/issues/287) ([ac121af](https://github.com/DanySK/publish-on-central/commit/ac121afdb7ce11d27e347d32c4dfffdf7c7d453b))
* improve instructions in case of missing jars with classifier ([92a991b](https://github.com/DanySK/publish-on-central/commit/92a991b8ef96c8d8a4baf4a959b98fe9dc0853d9))


### Dependency updates

* **deps:** bump semver-regex from 3.1.3 to 3.1.4 ([ca12ea0](https://github.com/DanySK/publish-on-central/commit/ca12ea05e00503e4da44c0572967b67a39768fe3))
* **deps:** update plugin multijvmtesting to v0.4.1 ([2a6ba83](https://github.com/DanySK/publish-on-central/commit/2a6ba83d88930fba30593d44b9555c5d4f420abf))
* **deps:** update plugin publishoncentral to v0.8.0 ([913242a](https://github.com/DanySK/publish-on-central/commit/913242ad3ef1a774d9243109422583a9e6fb13b6))


### Build and continuous integration

* add a ci-complete verification job ([828c453](https://github.com/DanySK/publish-on-central/commit/828c4538de38b6130d81ad38d47bc0172905a007))
* add content write permissions for GITHUB_TOKEN when releasing ([2335c6d](https://github.com/DanySK/publish-on-central/commit/2335c6d4040b125358880d85e5d6aab1bbdbe53b))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.0.1 ([3070889](https://github.com/DanySK/publish-on-central/commit/30708891ad237e18c9d3189ccd248f8f212984e0))
* **deps:** update danysk/build-check-deploy-gradle-action action to v2.0.2 ([f5384d2](https://github.com/DanySK/publish-on-central/commit/f5384d28ae90e2847f79650a649337df011bca7f))
* rename ci-complete to ci-success ([cb1ee5a](https://github.com/DanySK/publish-on-central/commit/cb1ee5a0c274132e5a44246d57c652f6c38c393a))
* use a custom deployment token ([15a2f20](https://github.com/DanySK/publish-on-central/commit/15a2f20c334d26d4436e2a3d34176522f855af87))

## [0.8.0](https://github.com/DanySK/publish-on-central/compare/0.7.19...0.8.0) (2022-06-02)


### Features

* preconfigure all publications to publish on Maven Central. The plugin now aggressively tries to add all the required artifacts to all the `MavenPublication`s. This should allow a streamlined publication of Kotlin-multiplatform artifacts. The feature can be turned off (resorting to manual configuration) by appropriate configuration in the build file. ([14b6b0a](https://github.com/DanySK/publish-on-central/commit/14b6b0aecaf5991c540a2b33fa02a9a72e3729e1))


### Build and continuous integration

* **deps:** update [secure]/build-check-deploy-gradle-action action to v1.2.14 ([8ff29fb](https://github.com/DanySK/publish-on-central/commit/8ff29fbf47851d3db45ec55c44775bd8ecd5f519))
* **deps:** update [secure]/build-check-deploy-gradle-action action to v1.2.15 ([1350ef5](https://github.com/DanySK/publish-on-central/commit/1350ef5315f47aee9941400903ef27b21a7d1ca0))
* **deps:** update [secure]/build-check-deploy-gradle-action action to v1.2.16 ([61aedf5](https://github.com/DanySK/publish-on-central/commit/61aedf5d301e2b1219264e0845eec8213c216093))
* **deps:** update [secure]/build-check-deploy-gradle-action action to v2 ([8763247](https://github.com/DanySK/publish-on-central/commit/8763247c0fde735b64c988b70234a611a8424197))
* enable the git hooks generation ([ef52639](https://github.com/DanySK/publish-on-central/commit/ef5263937812169e21cbc07a89f26bd20a2396a5))


### Dependency updates

* **deps:** bump npm from 8.3.1 to 8.12.0 ([cbe9d1e](https://github.com/DanySK/publish-on-central/commit/cbe9d1eb58dda6a7b2c6271b101f41b556045824))
* **deps:** drop unused test library (mockito) ([c27a0ec](https://github.com/DanySK/publish-on-central/commit/c27a0eca7bf658ce7455931897aa8f65bf881a8a))
* **deps:** update dependency org.mockito:mockito-core to v4.6.0 ([a4be576](https://github.com/DanySK/publish-on-central/commit/a4be576da58b9e1cb4c5ce88075f32c1e78fca02))
* **deps:** update dependency org.mockito:mockito-core to v4.6.1 ([69a0001](https://github.com/DanySK/publish-on-central/commit/69a0001685ab12037cf4970449bbd7bb0f8e3b81))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.6 ([492aa38](https://github.com/DanySK/publish-on-central/commit/492aa386e4decd7334e3554610310d991729780d))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.7 ([031d028](https://github.com/DanySK/publish-on-central/commit/031d0288cf8bf17ab78726d085b121ec79ce6289))
* **deps:** update io.kotest to v5.3.0 ([f4d2176](https://github.com/DanySK/publish-on-central/commit/f4d21769d61b5aafe0e784d708c1494069beeee1))
* **deps:** update node.js to 16.15 ([6744fd7](https://github.com/DanySK/publish-on-central/commit/6744fd7f920bbb4842b4af5ada38185f31b4f14a))
* **deps:** update plugin com.gradle.enterprise to v3.10.1 ([7eddca5](https://github.com/DanySK/publish-on-central/commit/7eddca57f01184f6f04ec46f36bbca0623eb09a7))
* **deps:** update plugin kotlin-qa to v0.16.2 ([e2e40af](https://github.com/DanySK/publish-on-central/commit/e2e40af5cb43cb73617b84786c3f5364452bc946))
* **deps:** update plugin kotlin-qa to v0.17.0 ([9e86cec](https://github.com/DanySK/publish-on-central/commit/9e86cec617a6ffd9b3dde788fc35c90031cbaeab))
* **deps:** update plugin kotlin-qa to v0.18.0 ([bd2509a](https://github.com/DanySK/publish-on-central/commit/bd2509ac977c2d328bc2e4e7f8833f279f000283))
* **deps:** update plugin kotlin-qa to v0.19.0 ([dfc8806](https://github.com/DanySK/publish-on-central/commit/dfc88067d9417fc35d2ecfac11bfeebc4b28fb8a))
* **deps:** update plugin multijvmtesting to v0.3.7 ([cbd62d1](https://github.com/DanySK/publish-on-central/commit/cbd62d104a99577db8fbe0cec5b3c5b733ddd91f))
* **deps:** update plugin multijvmtesting to v0.4.0 ([1d7c9fd](https://github.com/DanySK/publish-on-central/commit/1d7c9fdffadb21ce51d835430468a42eee4c6fc7))
* **deps:** update plugin publishoncentral to v0.7.19 ([dd78f2a](https://github.com/DanySK/publish-on-central/commit/dd78f2a9d08a9ffb5cdebcdbe5562e8a1df1e9c6))

### [0.7.19](https://github.com/DanySK/publish-on-central/compare/0.7.18...0.7.19) (2022-04-25)


### Build and continuous integration

* **deps:** update actions/checkout action to v3.0.2 ([a542432](https://github.com/DanySK/publish-on-central/commit/a542432d7f4802f7c5467bc40e000622c606fb97))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.13 ([2ead83a](https://github.com/DanySK/publish-on-central/commit/2ead83abf5c3e93cf24c03d253adde814e3a061d))


### Dependency updates

* **core-deps:** update plugin dokka to v1.6.21 ([13a952c](https://github.com/DanySK/publish-on-central/commit/13a952c2b2b6f0de3b072e88abf78d6e47cb2906))
* **deps:** update dependency org.mockito:mockito-core to v4.5.0 ([2155ae1](https://github.com/DanySK/publish-on-central/commit/2155ae159271a3c6a1e2327867850ddda4114dc5))
* **deps:** update dependency org.mockito:mockito-core to v4.5.1 ([30dcc2d](https://github.com/DanySK/publish-on-central/commit/30dcc2d30735d2a530ad8bd55af029c5ef2af86f))
* **deps:** update plugin publishoncentral to v0.7.18 ([5d267e6](https://github.com/DanySK/publish-on-central/commit/5d267e627de6e10b93096c204beec7cbf8d65bf6))

### [0.7.18](https://github.com/DanySK/publish-on-central/compare/0.7.17...0.7.18) (2022-04-19)


### Build and continuous integration

* **deps:** update actions/checkout action to v3.0.1 ([a382766](https://github.com/DanySK/publish-on-central/commit/a38276684f520b2fb0dd25ad776577a75c47e7cd))


### Dependency updates

* **core-deps:** update plugin kotlin-jvm to v1.6.21 ([f6b11b4](https://github.com/DanySK/publish-on-central/commit/f6b11b4bc9648aa2878ff9cdae3986f257e82440))
* **deps:** update plugin com.gradle.enterprise to v3.10 ([9626295](https://github.com/DanySK/publish-on-central/commit/962629528a76f1b95ac45d5e34262ce5aa659708))
* **deps:** update plugin kotlin-qa to v0.15.1 ([9c5d421](https://github.com/DanySK/publish-on-central/commit/9c5d421cd1bbf37cbf596be14c0c83e9d9e1b215))
* **deps:** update plugin kotlin-qa to v0.16.0 ([1ac2f0f](https://github.com/DanySK/publish-on-central/commit/1ac2f0fc7ddb2eb15b6fab6341cc94fdf3547d7c))
* **deps:** update plugin kotlin-qa to v0.16.1 ([66c6edb](https://github.com/DanySK/publish-on-central/commit/66c6edbd9bd461a4bc7b85901b8dc688f84041b6))
* **deps:** update plugin multijvmtesting to v0.3.6 ([5e270fb](https://github.com/DanySK/publish-on-central/commit/5e270fba80d737700b52dbcd77af7a295a06f141))
* **deps:** update plugin publishoncentral to v0.7.17 ([5c161fc](https://github.com/DanySK/publish-on-central/commit/5c161fc84811c73f59ac09c6f7bfe52e91f0bec9))

### [0.7.17](https://github.com/DanySK/publish-on-central/compare/0.7.16...0.7.17) (2022-04-14)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.10 ([4414478](https://github.com/DanySK/publish-on-central/commit/4414478e5f50b93d6a854db5258f7a1609d87218))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.11 ([f79655c](https://github.com/DanySK/publish-on-central/commit/f79655c47d6d77f5ad24ccce5457914d1826694c))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.12 ([1c58333](https://github.com/DanySK/publish-on-central/commit/1c58333ebaeff0d70ec8fbff6d23dbc11143004e))


### Dependency updates

* **core-deps:** update plugin dokka to v1.6.20 ([20383f5](https://github.com/DanySK/publish-on-central/commit/20383f5fb1bdc16370c2e4f53fee4db20d135432))
* **deps:** update io.kotest to v5.2.3 ([8b2dc15](https://github.com/DanySK/publish-on-central/commit/8b2dc15c11c900ba95853cf261f23079fd1e10ae))
* **deps:** update plugin kotlin-qa to v0.14.2 ([0927b6b](https://github.com/DanySK/publish-on-central/commit/0927b6b05519a66c2e2dca98021435d01f18e187))
* **deps:** update plugin kotlin-qa to v0.15.0 ([fab7b9a](https://github.com/DanySK/publish-on-central/commit/fab7b9a1821a161f5327b1e73ab7929569947f39))
* **deps:** update plugin multijvmtesting to v0.3.5 ([255c747](https://github.com/DanySK/publish-on-central/commit/255c74754436399444d116027a0da56225b49e27))
* **deps:** update plugin publishoncentral to v0.7.16 ([370784b](https://github.com/DanySK/publish-on-central/commit/370784b76a731a8f28b0880d0a6adabf4553e79a))

### [0.7.16](https://github.com/DanySK/publish-on-central/compare/0.7.15...0.7.16) (2022-04-04)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.8 ([89e458d](https://github.com/DanySK/publish-on-central/commit/89e458dc06eb99efcba1c8a5917e1389bde7d62e))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.9 ([ea0f8d6](https://github.com/DanySK/publish-on-central/commit/ea0f8d671678151f937061e3a485a28f597126d6))
* separate the versions of Kotlin and Dokka ([a918100](https://github.com/DanySK/publish-on-central/commit/a91810015d62814dc36719857438b2901f378667))


### Dependency updates

* **core-deps:** update plugin kotlin-jvm to v1.6.20 ([af0b93e](https://github.com/DanySK/publish-on-central/commit/af0b93e17d02d95d7807c7b438f5bfc57393341b))
* **deps:** bump minimist from 1.2.5 to 1.2.6 ([26fbcbb](https://github.com/DanySK/publish-on-central/commit/26fbcbb1e798c887eaaf3bcd33270c780e621353))
* **deps:** update plugin kotlin-qa to v0.14.1 ([8ca5562](https://github.com/DanySK/publish-on-central/commit/8ca556224cab0d4722dbbc695a340a925fcd411a))
* **deps:** update plugin publishoncentral to v0.7.15 ([d7b706f](https://github.com/DanySK/publish-on-central/commit/d7b706f61b9690837f01502bbcfe220caeaf441d))

### [0.7.15](https://github.com/DanySK/publish-on-central/compare/0.7.14...0.7.15) (2022-03-31)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.7 ([bae38dd](https://github.com/DanySK/publish-on-central/commit/bae38dd1376c79319e9aba4b300b5181b0d6a377))


### Dependency updates

* **core-deps:** update dependency gradle to v7.4.2 ([067687b](https://github.com/DanySK/publish-on-central/commit/067687b08c681cff413af00738cd91e0880a0843))
* **deps:** update dependency io.kotest:kotest-runner-junit5-jvm to v5.2.1 ([82d4dc1](https://github.com/DanySK/publish-on-central/commit/82d4dc10432e481c83de0e363b36ce011aa41282))
* **deps:** update io.kotest to v5 ([c75de97](https://github.com/DanySK/publish-on-central/commit/c75de97f4219cfa23e130e2cccced93e1f3aa631))
* **deps:** update io.kotest to v5.2.2 ([bb9d448](https://github.com/DanySK/publish-on-central/commit/bb9d44844cbdcb79c5c954a40d2c535ac84a20aa))
* **deps:** update plugin com.gradle.enterprise to v3.9 ([dac8b84](https://github.com/DanySK/publish-on-central/commit/dac8b844dd0ba3d15f8e986a443fe7fa949db0d9))
* **deps:** update plugin gradlepluginpublish to v0.21.0 ([5840fb7](https://github.com/DanySK/publish-on-central/commit/5840fb7a3e9366a736d02572eb2fb5c8c7dcabf2))
* **deps:** update plugin kotlin-qa to v0.12.1 ([e581429](https://github.com/DanySK/publish-on-central/commit/e581429a8a89319d60b0a32c05a5865bd69c9b05))
* **deps:** update plugin kotlin-qa to v0.13.0 ([e010145](https://github.com/DanySK/publish-on-central/commit/e0101451d245719d5f1c4dc07aecc38387775e58))
* **deps:** update plugin kotlin-qa to v0.14.0 ([084c66a](https://github.com/DanySK/publish-on-central/commit/084c66a73d02750a363a99e0d8e9ba30fe3d9133))
* **deps:** update plugin publishoncentral to v0.7.14 ([4254f83](https://github.com/DanySK/publish-on-central/commit/4254f839f7a80ef59bcfed866eb858d31f99949e))

### [0.7.14](https://github.com/DanySK/publish-on-central/compare/0.7.13...0.7.14) (2022-03-10)


### Build and continuous integration

* **deps:** update actions/checkout action to v3 ([ef14017](https://github.com/DanySK/publish-on-central/commit/ef14017345e40136dbbf13cc80a366e353ab3a0b))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.1 ([456174d](https://github.com/DanySK/publish-on-central/commit/456174da80928e932deace72c7af5e68ef4d5fc1))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.3 ([a85329c](https://github.com/DanySK/publish-on-central/commit/a85329c54193fe5a84e25f827e2c2792c4b4d64f))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.4 ([51766c7](https://github.com/DanySK/publish-on-central/commit/51766c746eb354ad0c7c6e1ca512cd2df356b106))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.6 ([9422518](https://github.com/DanySK/publish-on-central/commit/94225188377cc09ae23fa82399506bed56b3b700))


### Dependency updates

* **core-deps:** update dependency gradle to v7.4.1 ([4f8880a](https://github.com/DanySK/publish-on-central/commit/4f8880a41219edb803aa61cd44b2b1ea5eab7721))
* **deps:** update dependency node-fetch to 2.6.7 [security] ([6296608](https://github.com/DanySK/publish-on-central/commit/629660867789f1f1c0391647daaa4a6b4e810827))
* **deps:** update dependency org.mockito:mockito-core to v4.4.0 ([fd2e0bc](https://github.com/DanySK/publish-on-central/commit/fd2e0bca1a434441e8b7d63cf7c2adfee72e62ce))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.5 ([bb851d5](https://github.com/DanySK/publish-on-central/commit/bb851d59805592583e79c9a5c417678516b86feb))
* **deps:** update node.js to 16.14 ([721e619](https://github.com/DanySK/publish-on-central/commit/721e6194e95b1a8a0d988f63715bd5732ce18401))
* **deps:** update plugin kotlin-qa to v0.10.1 ([0400771](https://github.com/DanySK/publish-on-central/commit/04007716a40e30157791361e3ccf3c069abf1664))
* **deps:** update plugin kotlin-qa to v0.12.0 ([c964ccb](https://github.com/DanySK/publish-on-central/commit/c964ccb8e9703b287883e1910368dd3801bf075a))
* **deps:** update plugin publishoncentral to v0.7.13 ([d9875c8](https://github.com/DanySK/publish-on-central/commit/d9875c8233640fbf66c212c7d6f2a9b1a8314882))

### [0.7.13](https://github.com/DanySK/publish-on-central/compare/0.7.12...0.7.13) (2022-02-08)


### Dependency updates

* **core-deps:** update dependency gradle to v7.4 ([3d25c6f](https://github.com/DanySK/publish-on-central/commit/3d25c6fd094b0d90a1576103d05c35f27f847566))
* **deps:** update dependency org.mockito:mockito-core to v4.3.1 ([f48766f](https://github.com/DanySK/publish-on-central/commit/f48766f71c7f09171e1a6b99ff3675f78c58937e))
* **deps:** update plugin kotlin-qa to v0.10.0 ([d23eac6](https://github.com/DanySK/publish-on-central/commit/d23eac60b1ed52de826c8d57e398750bb0d885be))
* **deps:** update plugin publishoncentral to v0.7.12 ([fdc169f](https://github.com/DanySK/publish-on-central/commit/fdc169fb4bbaf715f003df8cba757c9841a921a2))

### [0.7.12](https://github.com/DanySK/publish-on-central/compare/0.7.11...0.7.12) (2022-01-25)


### Build and continuous integration

* **deps:** update danysk/build-check-deploy-gradle-action action to v1.1.3 ([da2e05f](https://github.com/DanySK/publish-on-central/commit/da2e05ffea204bc0e01070f05a201b6c92138624))
* **deps:** update danysk/build-check-deploy-gradle-action action to v1.2.0 ([4852534](https://github.com/DanySK/publish-on-central/commit/48525342a7c12397f8c6a11dd3b2cc0e09a19c95))


### Dependency updates

* **deps:** update dependency org.mockito:mockito-core to v4.3.0 ([2e4352f](https://github.com/DanySK/publish-on-central/commit/2e4352f3e97b9c4ecc9d1f0094c90c4ff68390c4))
* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.4 ([234ddfe](https://github.com/DanySK/publish-on-central/commit/234ddfeef68edf1dc65787e8d5608b430ae925da))
* **deps:** update plugin com.gradle.enterprise to v3.8.1 ([a8c2eae](https://github.com/DanySK/publish-on-central/commit/a8c2eae2c1cc0f2ffab74d893e0db21a8208ee74))
* **deps:** update plugin gradlepluginpublish to v0.20.0 ([b7fb0eb](https://github.com/DanySK/publish-on-central/commit/b7fb0eb2cd71ffa37fa61d26cd47d57158cd0459))
* **deps:** update plugin publishoncentral to v0.7.11 ([2950018](https://github.com/DanySK/publish-on-central/commit/2950018ee8b885f0b31c9bebb2d986ae8344fc5d))


### Documentation

* fix typo ([f42ab94](https://github.com/DanySK/publish-on-central/commit/f42ab942eb8de283f77917199b9e12b866c2a95f))

### [0.7.11](https://github.com/DanySK/publish-on-central/compare/0.7.10...0.7.11) (2022-01-09)


### General maintenance

* **release:** fail on failed publication ([83f87ec](https://github.com/DanySK/publish-on-central/commit/83f87ec4e7c28526e5f2326d135cdf03ec989caf))


### Style improvements

* **release:** use a more compact syntax for the release config ([f9d29f3](https://github.com/DanySK/publish-on-central/commit/f9d29f3a4943bb991d7af03ac1671e7dabeb64e0))


### Documentation

* **readme:** fix the list of automatically created tasks for custom Nexus repositories ([b864187](https://github.com/DanySK/publish-on-central/commit/b8641873520bc3754f8daf0e3b45cdbbfb69bd05))


### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.3 ([07abae9](https://github.com/DanySK/publish-on-central/commit/07abae9867a2a10a7e5a1e40eaa78681b800b44b))
* **deps:** update plugin multijvmtesting to v0.3.4 ([ce6bca2](https://github.com/DanySK/publish-on-central/commit/ce6bca244333dd3b881cb3781fa11ca3c3f77e5f))
* **deps:** update plugin publishoncentral to v0.7.10 ([37f8d64](https://github.com/DanySK/publish-on-central/commit/37f8d64e94b44bd656c70aa86ddd1676cb02be9d))

### [0.7.10](https://github.com/DanySK/publish-on-central/compare/0.7.9...0.7.10) (2022-01-06)


### Bug Fixes

* **release:** correctly enable semantic commit conventions ([b9785cb](https://github.com/DanySK/publish-on-central/commit/b9785cb49174999c3823f8af634b707e80e92045))


### Dependency updates

* **deps:** update dependency semantic-release-preconfigured-conventional-commits to v1.1.1 ([503f293](https://github.com/DanySK/publish-on-central/commit/503f2938697f1e9bf0e5396d22a9a09f8d70f118))
* **deps:** update plugin gradlepluginpublish to v0.19.0 ([15c821e](https://github.com/DanySK/publish-on-central/commit/15c821e540463121171b7d96a02c83c9366744c3))
* **deps:** update plugin kotlin-qa to v0.8.3 ([d4244b0](https://github.com/DanySK/publish-on-central/commit/d4244b0b771355a95f325f17e53a4b052878b75e))
* **deps:** update plugin kotlin-qa to v0.9.0 ([9efecce](https://github.com/DanySK/publish-on-central/commit/9efecce7074a2b8e767d0621328c630d286f7a4a))
* **deps:** update plugin multijvmtesting to v0.3.3 ([59bedf6](https://github.com/DanySK/publish-on-central/commit/59bedf638811b0bd3568ab274b35185926949399))
* **deps:** update plugin publishoncentral to v0.7.9 ([35cc253](https://github.com/DanySK/publish-on-central/commit/35cc253aae9e60e0193f1cd9573b5e281077ce73))


### Build and continuous integration

* **release:** enable commit-analyzer ([ed191d9](https://github.com/DanySK/publish-on-central/commit/ed191d984eb6a97e24f2f5fe51228a8ae875e4db))
* **release:** inherit the configuration from the shared preset ([#191](https://github.com/DanySK/publish-on-central/issues/191)) ([0bce9c5](https://github.com/DanySK/publish-on-central/commit/0bce9c5ac7b85706eed385d3dd30430d96fd68fb))

## [0.7.9](https://github.com/DanySK/publish-on-central/compare/0.7.8...0.7.9) (2021-12-27)


### Bug Fixes

* **deps:** update plugin dokka to v1.6.10 ([139cc40](https://github.com/DanySK/publish-on-central/commit/139cc40043a5c530dcad5d0653f639be639866d6))

## [0.7.8](https://github.com/DanySK/publish-on-central/compare/0.7.7...0.7.8) (2021-12-22)


### Bug Fixes

* **deps:** update dependency gradle to v7.3.3 ([4880663](https://github.com/DanySK/publish-on-central/commit/4880663c38c6c30848a6e0a5b96d1d79e653d4e4))

## [0.7.7](https://github.com/DanySK/publish-on-central/compare/0.7.6...0.7.7) (2021-12-15)


### Bug Fixes

* **deps:** update dependency gradle to v7.3.2 ([77d54f5](https://github.com/DanySK/publish-on-central/commit/77d54f546a2f04244dcb5897899125c9c6522cef))

## [0.7.6](https://github.com/DanySK/publish-on-central/compare/0.7.5...0.7.6) (2021-12-01)


### Bug Fixes

* **deps:** update dependency gradle to v7.3.1 ([10259f2](https://github.com/DanySK/publish-on-central/commit/10259f2fe8655fae98b38ed0f1c0c3e5998da163))

## [0.7.5](https://github.com/DanySK/publish-on-central/compare/0.7.4...0.7.5) (2021-11-27)


### Bug Fixes

* **logging:** warn only if publishing tasks get executed ([d5cf58d](https://github.com/DanySK/publish-on-central/commit/d5cf58d155f4608701eef5137e5055d199f7c05b))

## [0.7.4](https://github.com/DanySK/publish-on-central/compare/0.7.3...0.7.4) (2021-11-26)


### Bug Fixes

* try to publish the Kotlin publication on GH packages ([7ef1d15](https://github.com/DanySK/publish-on-central/commit/7ef1d1535b8f72a7c555e93f7f25a45349136f96))

## [0.7.3](https://github.com/DanySK/publish-on-central/compare/0.7.2...0.7.3) (2021-11-26)


### Bug Fixes

* read GITHUB_TOKEN from the environment ([8fb018b](https://github.com/DanySK/publish-on-central/commit/8fb018bb6b9b1079362fe06ce9aeee437d89ae4d))
* temporarily disable all CI checks to fiddle with semantic release ([4b1e97b](https://github.com/DanySK/publish-on-central/commit/4b1e97b17d3ae722344c99027a6d62050d610322))
* try to force semantic release to annotate the tag, see issue semantic-release/semantic-release[#1871](https://github.com/DanySK/publish-on-central/issues/1871) ([c479ac3](https://github.com/DanySK/publish-on-central/commit/c479ac3b1ce80789ff450eb6089701823e8742c6))

## [0.7.2](https://github.com/DanySK/publish-on-central/compare/0.7.1...0.7.2) (2021-11-26)


### Bug Fixes

* ignore node_modules ([da4976d](https://github.com/DanySK/publish-on-central/commit/da4976d340bd45fdd95accebe45fb4b56aa35bf6))

# [0.7.0](https://github.com/DanySK/publish-on-central/compare/0.6.1...0.7.0) (2021-11-26)


### Bug Fixes

* add Nexus tasks for each publication ([9ad0d5b](https://github.com/DanySK/publish-on-central/commit/9ad0d5bd99b7b3570d0009790843b74e98ba19b2))
* adjust dependencies among tasks ([ae0f6ef](https://github.com/DanySK/publish-on-central/commit/ae0f6ef4eafb71d9ebaeb9602f7c57bf3173f02b))
* describe the release Nexus task ([a520c94](https://github.com/DanySK/publish-on-central/commit/a520c94e771bbd5424f887a2c4877fa1e3faac12))
* filter repository targets before binding Nexus ([29491a9](https://github.com/DanySK/publish-on-central/commit/29491a9bfd4f531e6a35c107cb9902f800314cd1))
* pass the credentials to Nexus ([ed9cd3e](https://github.com/DanySK/publish-on-central/commit/ed9cd3ec4a85835aec7421d44e0eff0f7fc6fcc1))
* provide a snapshot repository ([9cfed80](https://github.com/DanySK/publish-on-central/commit/9cfed80ab35283132459cbcf32920dcd51ce0155))
* remove printlns ([fd696a0](https://github.com/DanySK/publish-on-central/commit/fd696a0dd67ed39bf43e0226b7a962ffbb3cd034))
* require snapshot repositories for Nexus staging ([9c2182f](https://github.com/DanySK/publish-on-central/commit/9c2182f8324be0c896927dbb5f5b7096679c5e99))
* use the logger for informing on lifecycle progress ([3a00662](https://github.com/DanySK/publish-on-central/commit/3a00662da2f292b2a330d706889adc99d2b1f4ac))
* use transitioners ([f659e7b](https://github.com/DanySK/publish-on-central/commit/f659e7bda0e50a48b6c04ac3f19b36289c87b5ce))


### Features

* experimental support for Nexus ([6bba219](https://github.com/DanySK/publish-on-central/commit/6bba2192d919484f01fa04453fe09b113c8132f7))

# 0.6.1
* The `assemble` task (if existing) now depends on `sourcesJar` and `javadocJar`
* Removed references to `maven-central-gradle-plugin` in favor of `publish-on-central`

# 0.6.0

* Adds better support for the Snapshot repository of Central.
* Repository final configuration is now delayed and performed `afterEvaluate`.
* Improved internal structure
* Enabled a better quality assurance

# 0.5.0

* The default repository URL for Maven Central switches to `https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/`
  (see: [https://central.sonatype.org/publish/publish-gradle/](https://central.sonatype.org/publish/publish-gradle/))
