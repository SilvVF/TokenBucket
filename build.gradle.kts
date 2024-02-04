import java.util.Properties

plugins {
    `maven-publish`
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
}

val properties = Properties()
properties.load(project.rootProject.file("local.properties").inputStream())

val GITHUB_USERNAME: String = properties.getProperty("GITHUB_USERNAME")
val GITHUB_TOKEN: String = properties.getProperty("GITHUB_TOKEN")

subprojects {

    group = "io.silv.tokenbucket"
    version = "1.0.0"

    apply(plugin = "maven-publish")

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                setUrl("https://maven.pkg.github.com/SilvVF/TokenBucket")
                credentials {
                    username = GITHUB_USERNAME
                    password = GITHUB_TOKEN
                }
            }
        }
        publications {
            register<MavenPublication>("gpr")
        }
    }
}