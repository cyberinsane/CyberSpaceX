package com.cyberinsane.spacex

import BuildSettings
import Libs
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/**
 * This plugin applies to each library module in the project
 */
class AndroidLibraryModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            applyPlugins()
            configureAndroidLibrary()
        }
    }
}

/**
 * Applies gradle plugins required for all android libraries
 */
private fun Project.applyPlugins() {
    pluginManager.apply {
        apply("com.android.library")
        apply("kotlin-android")
        apply("kotlin-android-extensions")
        apply("kotlin-kapt")
    }
}

/**
 * Applies android library configurations
 */
private fun Project.configureAndroidLibrary() {
    extensions.getByType<LibraryExtension>().apply {
        compileSdk = BuildSettings.COMPILE_SDK_VERSION
        buildToolsVersion = Libs.Android.androidBuildTools

        defaultConfig {
            minSdk = BuildSettings.MIN_SDK_VERSION
            targetSdk = BuildSettings.TARGET_SDK_VERSION

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            consumerProguardFiles("consumer-rules.pro")
        }

        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
                )
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

//        kotlinOptions {
//            jvmTarget = "1.8"
//        }
    }
}

///**
// * Configures the [kotlinOptions][KotlinJvmOptions] extension.
// */
//private fun LibraryExtension.kotlinOptions(configure: Action<KotlinJvmOptions>) =
//    (this as ExtensionAware).extensions.configure("kotlinOptions", configure)