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
}