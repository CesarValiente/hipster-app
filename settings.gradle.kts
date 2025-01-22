pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "hipsterApp"

include(":app")
include(":marvel-app")
include(":foundation")
include(":foundation:network")
include(":foundation:data-mock")
include(":foundation:data")
