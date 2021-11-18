enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"

// main project
include(":app")

// components
include(":common")
include(":explore")
include(":selltrade")
include(":mycars")
include(":account")
include(":prequal")

// harness apps
include(":explore:harnessapp")
include(":mycars:harnessapp")
include(":prequal:harnessapp")
include(":selltrade:harnessapp")
include(":account:harnessap")
