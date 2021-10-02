plugins {
    id("org.openjfx.javafxplugin") version "0.0.8"
}

repositories {
    mavenCentral()
}

javafx {
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {
    implementation("no.tornado:tornadofx:1.7.17")

    implementation("org.jfxtras:jmetro:11.6.14")

    implementation("com.github.Minestom:Minestom:e71c420fa8")

    implementation(kotlin("reflect"))

    implementation(project(":common"))
}