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

    implementation(libs.bundles.quarkus.hibernate)
    implementation(libs.quarkus.postgresql)

    implementation(libs.bundles.kotlin)
    implementation(libs.kotlin.serialization.json)

    implementation(libs.quarkus.docker.image)

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

tasks.register<Exec>("buildNativeAotDocker") {
    group = "build"

    executable = getGradleWrapperByOs()
    args = listOf(
        "build",
        "--rerun-tasks",
        "-Dquarkus.native.enabled=true",
        "-Dquarkus.package.jar.enabled=false",
        "-Dquarkus.container-image.build=true",
        "-Dquarkus.native.additional-build-args=--initialize-at-run-time=kotlin.uuid.SecureRandomHolder",
    )

    workingDir = project.rootDir

    isIgnoreExitValue = false
    standardOutput = System.out
    errorOutput = System.err
}


tasks.register<Exec>("buildDockerImage") {
    group = "build"
    outputs.upToDateWhen { false }


    executable = getGradleWrapperByOs()
    args = listOf(
        "build",
        "--rerun-tasks",
        "-Dquarkus.container-image.build=true"
    )

    workingDir = project.rootDir

    isIgnoreExitValue = false
    standardOutput = System.out
    errorOutput = System.err
}

fun getGradleWrapperByOs(): String {
    val isWindows: Boolean = System.getProperty("os.name").contains("win", ignoreCase = true)
    if (isWindows) {
        return "gradlew.bat"
    }
    return "./gradlew"
}