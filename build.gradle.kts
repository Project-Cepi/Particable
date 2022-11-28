plugins {
    kotlin("jvm") version "1.7.22"
    java
    `maven-publish`
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
        compileOnly(kotlin("stdlib"))

        compileOnly(kotlin("reflect"))

        // Use the JUpiter test library.
        testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    }

    tasks {
        test { useJUnitPlatform() }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
    compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.properties["group"] as? String?
                artifactId = project.name
                version = project.properties["version"] as? String?

                from(components["java"])
            }
        }
    }
}