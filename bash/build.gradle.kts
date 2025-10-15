plugins {
    // Apply the shared build logic from a convention plugin.
    // The shared code is located in `buildSrc/src/main/kotlin/kotlin-jvm.gradle.kts`.
    id("buildsrc.convention.kotlin-jvm")
    alias(libs.plugins.kotest)
    alias(libs.plugins.kotlinPluginSerialization)
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.bundles.testing)
    implementation(libs.kotlinxSerialization)
    implementation(project(":utils"))
}

tasks.test {
    useJUnitPlatform()
    environment(properties.filter { it.key == "selfie" })
    inputs.files(fileTree("src/test") {
        include("**/*.ss")
    })
}
