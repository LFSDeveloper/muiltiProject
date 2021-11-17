include(":account:harnessap")

dependencyResolutionManagement {

    // creating dependency catalog
//    versionCatalogs {
//        create("libs") {
//            from(files("gradle/libs.versions.toml"))
//        }
//    }

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
include(":common")
include(":explore")
include(":selltrade")
include(":mycars")
include(":account")
include(":prequal")

enableFeaturePreview("VERSION_CATALOGS")
include(":explore:harnessapp")
include(":mycars:harnessapp")
include(":prequal:harnessapp")
include(":selltrade:harnessapp")
