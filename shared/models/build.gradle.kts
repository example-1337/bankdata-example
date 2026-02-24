plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    applyDefaultHierarchyTemplate()

    js {
        browser()
    }

    jvm {
        kotlin {
            jvmToolchain(25)
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
            maxParallelForks = Runtime.getRuntime().availableProcessors() / 2
        }
    }
    sourceSets {

        val commonMain by getting {
            dependencies {
                implementation(libs.bundles.kotlin)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val jsMain by getting {}
        val jsTest by getting {}

        val jvmMain by getting {}
        val jvmTest by getting {}
    }
}