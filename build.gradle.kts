import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("org.jetbrains.intellij.platform") version "2.9.0"
    java
    kotlin("jvm") version "2.2.20"
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
        intellijIdeaCommunity("2025.2.1")
    }

    implementation(kotlin("stdlib-jdk7"))
    implementation(kotlin("reflect"))
    testImplementation("junit", "junit", "4.12")
}

intellijPlatform {
    pluginConfiguration {
        version = project.properties["version"] as String
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}
