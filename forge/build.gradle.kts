import java.util.Date
import org.gradle.api.file.DuplicatesStrategy.EXCLUDE

val mcVersion:              String by rootProject
val modID:                  String by rootProject
val modName:                String by rootProject
val uname:                  String by rootProject
val architecturyApiVersion: String by rootProject
val mcForgeVersion:         String by project
val kotlinForForgeVersion:  String by project

version = "${project.name}${mcVersion}-${rootProject.version}"

repositories {
    maven("https://thedarkcolour.github.io/KotlinForForge")
    maven("https://maven.minecraftforge.net")
}

architectury {
    platformSetupLoomIde()
    forge()
}

dependencies {
    "forge"("net.minecraftforge:forge:${mcVersion}-${mcForgeVersion}")
    modApi("me.shedaniel:architectury-forge:${architecturyApiVersion}")
    modImplementation("thedarkcolour:kotlinforforge:${kotlinForForgeVersion}")

    implementation(project(":common"))
}

tasks {
    for (task in listOf(jar, remapJar)) task.get().apply {
        archiveBaseName.set(rootProject.name)
        duplicatesStrategy = EXCLUDE

        metaInf {
            from(rootDir) {
                include("LICENSE")
            }

            from(project.sourceSets.main.get().resources.asPath) {
                filesMatching("mods.toml") {
                    expand(mutableMapOf(
                        "modID"   to modID,
                        "version" to rootProject.version,
                        "modName" to modName,
                        "uname"   to uname
                    ))
                }
            }
        }

        manifest {
            attributes(
                "Specification-Title" to modID,
                "Specification-Vendor" to uname,
                "Specification-Version" to "1",
                "Implementation-Title" to rootProject.name,
                "Implementation-Version" to project.version,
                "Implementation-Vendor" to uname,
                "Implementation-Timestamp" to Date()
            )
        }

        from(
            project(":common").sourceSets.main.get().output,
            project(":common").sourceSets.main.get().resources
        )
    }
}
