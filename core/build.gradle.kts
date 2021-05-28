plugins {
    id("android-library-module")
}

android {
    // Override Android configurations
}

dependencies {
    implementation(localJars())

    // Provided by core to dependent modules
    api(Libs.AndroidX.appcompat)
    api(Libs.Kotlin.Coroutines.android)

    // Test Implementations
    testApi(Libs.Kotlin.Coroutines.test)
    testApi(Libs.JUnit.junit)
    androidTestApi(Libs.AndroidX.Test.Ext.junit)
    androidTestApi(Libs.AndroidX.Test.espressoCore)
}
