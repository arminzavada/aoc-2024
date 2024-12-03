package hu.zavada.armin.gradle

import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("org.jetbrains.kotlin.jvm")
}

group = "hu.zavada.armin.aoc-2024"
version = "0.0.1"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
}

val libs = the<LibrariesForLibs>()

dependencies {
    testImplementation(libs.junit.api)
    testImplementation(libs.junit.params)

    testRuntimeOnly(libs.junit.engine)
}

tasks.test {
    useJUnitPlatform()

    testLogging {
        events("started", "failed", "passed", "skipped", "standard_out", "standard_error")

        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showExceptions = true
        showCauses = true
        showStackTraces = true
    }
}
