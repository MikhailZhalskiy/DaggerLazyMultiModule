pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "DaggerLazyMultiModule"
include(":app")
include(":repository_api")
include(":repository_impl")
include(":injector")
include(":feature_list_impl")
include(":feature_list_api")
include(":feature_detail_impl")
include(":feature_detail_api")
include(":injector_compose")
include(":feature_pdf_impl")
include(":feature_pdf_api")
