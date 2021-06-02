import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileTree

object Libs {

    object Android {
        const val androidBuildTools = "30.0.3"
        const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.0-beta02"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.3.0"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-alpha08"
        }

        object Compose {
            const val version = "1.0.0-beta07"

            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val material = "androidx.compose.material:material:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object Navigation {
            private const val version = "2.4.0-alpha01"
            const val navigationCompose = "androidx.navigation:navigation-compose:$version"
        }

        object Lifecycle {
            private const val version = "2.2.0"
            const val viewModelExt = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object StartUp {
            private const val version = "1.0.0"
            const val startup = "androidx.startup:startup-runtime:$version"
        }

        object Test {
            private const val version = "1.3.0"
            const val runner = "androidx.test:runner:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
        }
    }

    object Kotlin {
        private const val version = "1.4.32"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"

        object Coroutines {
            private const val version = "1.5.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Hilt {
        private const val version = "2.35"

        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val testing = "com.google.dagger:hilt-android-testing:$version"

        private const val versionNavCompose = "1.0.0-alpha02"
        const val navigationCompose = "androidx.hilt:hilt-navigation-compose:$versionNavCompose"
    }

    object JUnit {
        private const val version = "4.13.2"
        const val junit = "junit:junit:$version"
    }

    object Material {
        private const val version = "1.4.0-beta01"
        const val material = "com.google.android.material:material:$version"
    }

    object OKHttp {
        private const val version = "4.8.0"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val mockServer = "com.squareup.okhttp3:mockwebserver:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
    }

    object Moshi {
        private const val version = "1.12.0"
        const val moshi = "com.squareup.moshi:moshi-kotlin-codegen:$version"
    }

    object Timber {
        private const val version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:$version"
    }
}

/**
 * Method to add local libraries as dependencies
 */
fun Project.localJars(): ConfigurableFileTree {
    return fileTree(
        mapOf(
            "dir" to "libs",
            "include" to listOf("*.jar", "*.aar")
        )
    )
}