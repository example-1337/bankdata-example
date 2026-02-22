plugins {
    kotlin("jvm")
}

dependencies {
    implementation(libs.bundles.kotlin.test)
}

kotlin {
    jvmToolchain(25)
}
tasks.test {
    useJUnitPlatform()
}