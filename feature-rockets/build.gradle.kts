plugins {
    id("android-library-module")
    id("dagger.hilt.android.plugin")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    implementation(project(":core"))

    // Hilt
    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.navigationCompose)
    kapt(Libs.Hilt.compiler)

    // Moshi
    kapt(Libs.Moshi.moshi)
}
