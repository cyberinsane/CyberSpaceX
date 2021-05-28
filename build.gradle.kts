plugins {
    id("org.jlleitschuh.gradle.ktlint") version "10.0.0"
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.Android.androidGradlePlugin)
        classpath(Libs.Kotlin.gradlePlugin)
        classpath(Libs.Hilt.gradlePlugin)
    }
}

subprojects {
    // Apply jlleitschuh - ktlint plugin to all modules
    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
    }

    // Configure ktlint
    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        version.set("0.41.0")
        debug.set(true)
        disabledRules.set(listOf("no-wildcard-imports"))
    }

    // Set JVM target for all modules
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
