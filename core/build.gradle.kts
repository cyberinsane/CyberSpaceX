plugins {
    id("android-library-module")
    id("dagger.hilt.android.plugin")
}

android {
    // Override Android configurations
}

dependencies {
    implementation(localJars())

    // Provided by core to dependent modules
    // Timber
    api(Libs.Timber.timber)

    api(Libs.AndroidX.appcompat)
    api(Libs.AndroidX.Activity.activityCompose)
    api(Libs.AndroidX.Lifecycle.viewModelExt)

    // Compose
    api(Libs.AndroidX.Compose.runtime)
    api(Libs.AndroidX.Compose.ui)
    api(Libs.AndroidX.Compose.tooling)
    api(Libs.AndroidX.Compose.material)
    api(Libs.AndroidX.Navigation.navigationCompose)

    // Material
    api(Libs.Material.material)

    // Coroutines
    api(Libs.Kotlin.Coroutines.android)

    // Hilt
    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.navigationCompose)
    kapt(Libs.Hilt.compiler)

    // Networking - Retrofit
    api(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.moshiConverter)
    api(Libs.OKHttp.interceptor)

    // Moshi
    api(Libs.Moshi.moshi)
    kapt(Libs.Moshi.moshi)

    // Test Implementations
    testApi(Libs.Kotlin.Coroutines.test)
    testApi(Libs.JUnit.junit)
    androidTestApi(Libs.AndroidX.Test.Ext.junit)
    androidTestApi(Libs.AndroidX.Test.espressoCore)
}
