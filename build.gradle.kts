import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    id("org.jetbrains.intellij.platform") version "2.11.0"
    java
    kotlin("jvm") version "1.9.24"
}

group = "org.crystal.intellij"

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

sourceSets {
    main {
        java.srcDir("src/main/gen")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    intellijPlatform {
        bundledPlugin("org.jetbrains.plugins.yaml")
        androidStudio("2024.2.1.11") // Ladybug stable
        testFramework(TestFrameworkType.Platform)
    }

    implementation(kotlin("stdlib-jdk7"))
    implementation(kotlin("reflect"))
    testImplementation("junit", "junit", "4.12")
    testImplementation(kotlin("test"))
    testRuntimeOnly("org.opentest4j:opentest4j:1.3.0")
}

intellijPlatform {
    pluginConfiguration {
        version = project.properties["version"]?.toString() ?: "1.0.0"
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}
