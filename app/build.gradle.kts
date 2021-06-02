plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildSettings.COMPILE_SDK_VERSION
    buildToolsVersion = Libs.Android.androidBuildTools

    defaultConfig {
        applicationId = "com.cyberinsane.spacex"
        versionCode = 1
        versionName = "1.0"

        minSdk = BuildSettings.MIN_SDK_VERSION
        targetSdk = BuildSettings.TARGET_SDK_VERSION

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":feature-company"))

    // Start-up
    implementation(Libs.AndroidX.StartUp.startup)

    // Compose Test
    androidTestImplementation(Libs.AndroidX.Compose.uiTest)

    // Hilt
    implementation(Libs.Hilt.android)
    implementation(Libs.Hilt.navigationCompose)
    kapt(Libs.Hilt.compiler)

    kapt(Libs.Moshi.moshi)
}
