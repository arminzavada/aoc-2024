plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "aoc-2024"

include(
    "day-1",
    "day-2",
)

rootProject.children.forEach { project ->
    project.projectDir = file("subprojects/${project.name}")
}
