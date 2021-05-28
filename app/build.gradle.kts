plugins {
    id("com.android.application")
    id("kotlin-android")
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

    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.Material.material)

    // Compose
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.tooling)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Activity.activityCompose)

    // Compose Test
    androidTestImplementation(Libs.AndroidX.Compose.uiTest)
}
