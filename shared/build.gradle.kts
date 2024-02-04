plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

group = "io.silv.tokenbucket"
version = "1.0.0"

publishing {
    repositories {
        maven {
            setUrl("https://maven.pkg.github.com/SilvVF/TokenBucket")
        }
    }
}

kotlin {
    androidTarget {
        compilations.all {

            publishLibraryVariants("release", "debug")
            publishLibraryVariantsGroupedByFlavor = true

            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlinx.coroutines.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {

    namespace = "io.silv.tokenbucket"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}
