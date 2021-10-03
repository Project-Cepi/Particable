plugins {
    kotlin("jvm") version "1.5.21"
    java
}

group = "org.jglrxavpok.nbt"
version = "2.0.0"

allprojects {
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral()
        maven(url = "https://repo.spongepowered.org/maven")
        maven(url = "https://jitpack.io")
    }

    dependencies {
        // Use the Kotlin JDK 8 standard library.
        implementation(kotlin("stdlib"))

        implementation(kotlin("reflect"))

        // Use the JUpiter test library.
        testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
    }

    tasks {
        test { useJUnitPlatform() }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_16
        targetCompatibility = JavaVersion.VERSION_16
    }

    val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
    compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_16.toString()
}