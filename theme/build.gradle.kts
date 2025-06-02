import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")

}

kotlin {
    androidTarget()
    jvm()

    sourceSets {
        androidMain.dependencies {
            implementation("androidx.compose.ui:ui:1.8.2")
        }
        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.xteam.themecore"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.xteam.kmm"
            artifactId = "theme-core"
            version = "1.0.0"

            from(components["kotlin"])
        }
    }
    repositories {
        mavenLocal()
    }
}
