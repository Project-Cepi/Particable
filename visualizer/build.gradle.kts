plugins {
    id("org.openjfx.javafxplugin") version "0.0.8"
}

repositories {
    mavenCentral()
    maven(url = "https://repo.spongepowered.org/maven")
    maven(url = "https://jitpack.io")
}
javafx {
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    implementation("no.tornado:tornadofx:1.7.20")

    implementation("org.jfxtras:jmetro:11.6.14")

    implementation("com.github.Minestom:Minestom:e71c420fa8")

    implementation(kotlin("reflect"))

    implementation(project(":common"))
}