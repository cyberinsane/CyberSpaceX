plugins {
    `kotlin-dsl`
}

// The kotlin-dsl plugin requires a repository to be declared
repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.0-beta02")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
}

gradlePlugin {
    plugins {
        register("android-library-module") {
            id = "android-library-module"
            implementationClass = "com.cyberinsane.spacex.AndroidLibraryModulePlugin"
        }
    }
}