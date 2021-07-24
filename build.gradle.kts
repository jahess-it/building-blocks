import net.fabricmc.loom.LoomGradleExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

lateinit var mojMap: Dependency
val majorVersion:    String by rootProject
val minorVersion:    String by rootProject
val patchNum:        String by rootProject
val type:            String by rootProject
val mcVersion:       String by rootProject
val jvmVersion:      String by rootProject

plugins {
    kotlin("jvm") version "1.5.21"
    id("architectury-plugin") version "3.2-SNAPSHOT"
    id("dev.architectury.loom") version "0.7.2-SNAPSHOT" apply false
}

subprojects {
    apply(plugin = "dev.architectury.loom")

    configure<LoomGradleExtension> {
        silentMojangMappingsLicense()

        mojMap = officialMojangMappings()
    }

    dependencies {
        // Use the Kotlin JDK 8 standard library.
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // Align versions of all Kotlin components
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

        // Use JUnit Jupiter API for testing.
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")

        // Use JUnit Jupiter Engine for testing.
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

        "minecraft"("com.mojang:minecraft:${mcVersion}")
        "mappings"(mojMap)
    }
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "architectury-plugin")

    group = "com.jahessit.minecraft"
    rootProject.version = "${majorVersion}.${minorVersion}.${patchNum}${if (type == "release") "" else "-${type}"}"

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = jvmVersion
    }
}
