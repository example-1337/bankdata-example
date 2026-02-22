plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.jandex)
}

dependencies {
    implementation(enforcedPlatform(libs.quarkus.platform.bom))
    implementation(libs.bundles.quarkus.kotlin)

    implementation(libs.bundles.kotlin)
    implementation(libs.kotlin.serialization.xml.serialization)

    implementation(project(":shared:utils"))
    implementation(project(":shared:models"))

    testImplementation(libs.bundles.kotlin.test)
    testImplementation(libs.bundles.quarkus.test)
    testImplementation(project(":shared:testHelpers"))
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors() / 2
}