dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}
rootProject.name = "CyberSpaceX"
include(":app")
include(":core")
include(":feature-company")
include(":feature-rockets")
include(":feature-launches")
