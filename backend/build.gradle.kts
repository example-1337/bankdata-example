plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.quarkus)
}

group = "example.bankdata"
version = "1.0.0-SNAPSHOT"

dependencies {
    implementation(enforcedPlatform(libs.quarkus.platform.bom))
    implementation(libs.bundles.quarkus.kotlin)

    implementation(libs.bundles.kotlin)
    implementation(libs.kotlin.serialization.json)

    implementation(project(":shared:utils"))
    implementation(project(":shared:models"))
    implementation(project(":external-services"))

    testImplementation(libs.bundles.kotlin.test)
    testImplementation(libs.bundles.quarkus.test)
    testImplementation(project(":shared:testHelpers"))
}

tasks.test {
    useJUnitPlatform {
        excludeTags("integration")
    }

    maxParallelForks = Runtime.getRuntime().availableProcessors() / 2

    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
    jvmArgs("--add-opens", "java.base/java.lang=ALL-UNNAMED")
}


tasks.register<Test>("integrationTest") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().runtimeClasspath

    shouldRunAfter(tasks.test)

    useJUnitPlatform {
        includeTags("integration")
    }
}

kotlin {
    jvmToolchain(25)
}