plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
                outputFileName = "main.mjs"
            }
        }
        compilerOptions {
            target = "es2015"
        }
        useEsModules()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            val kotlinWrappersVersion = "2026.2.17"
            dependencies {
                implementation(project.dependencies.platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:$kotlinWrappersVersion"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")

                //https://github.com/JetBrains/kotlin-wrappers/blob/master/gradle.properties
                api(npm("react", "19.2.4"))
                api(npm("react-dom", "19.2.4"))

                implementation(libs.kotlin.coroutines.core)
                implementation(libs.kotlin.serialization.json)
            }
        }
    }
}
