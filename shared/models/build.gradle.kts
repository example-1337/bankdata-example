plugins {
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.bundles.kotlin)
    testImplementation(libs.bundles.kotlin.test)
    testImplementation(project(":shared:testHelpers"))
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors() / 2
}