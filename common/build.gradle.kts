plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    maven(url = "https://repo.spongepowered.org/maven")
    maven(url = "https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Minestom:Minestom:4ee5cbe424")
    testImplementation("com.github.Minestom:Minestom:4ee5cbe424")
}

tasks {
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        archiveBaseName.set("particable")
        mergeServiceFiles()
        minimize()
    }

    build { dependsOn(shadowJar) }
}