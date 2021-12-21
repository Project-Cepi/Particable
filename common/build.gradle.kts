plugins {
    id("com.github.johnrengelman.shadow") version "7.1.1"
}

repositories {
    mavenCentral()
    maven(url = "https://repo.spongepowered.org/maven")
    maven(url = "https://jitpack.io")
}

dependencies {
    compileOnly("com.github.emortaldev:Minestom:01c28d0818")
    testImplementation("com.github.emortaldev:Minestom:01c28d0818")
}

tasks {
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        archiveBaseName.set("particable")
        mergeServiceFiles()
        minimize()
    }

    build { dependsOn(shadowJar) }
}