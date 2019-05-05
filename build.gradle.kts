import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.net.URI

plugins {
    kotlin("jvm") version "1.3.31"
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "flavor.pie"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        name = "Sponge"
        url = URI("https://repo.spongepowered.org/maven/")
    }
    maven {
        name = "Spigot"
        url = URI("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        name = "Jitpack"
        url = URI("https://jitpack.io/")
    }
    maven {
        name = "Sonatype Central"
        url = URI("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.pie-flavor:kludge:477392a")
    api("org.spongepowered:spongeapi:7.1.0")
    api("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}