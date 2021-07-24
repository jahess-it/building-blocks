import kotlin.collections.*

val mcVersion:                   String by rootProject
val modID:                       String by rootProject
val modName:                     String by rootProject
val description:                 String by rootProject
val uname:                       String by rootProject
val jvmVersion:                  String by rootProject
val fabricLoaderVersion:         String by rootProject
val architecturyApiVersion:      String by rootProject
val fabricLanguageKotlinVersion: String by project
val fabricApiVersion:            String by project

version = "${project.name}${mcVersion}-${rootProject.version}"

architectury {
    platformSetupLoomIde()
    fabric()
}

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${fabricLoaderVersion}")
    modImplementation("net.fabricmc:fabric-language-kotlin:${fabricLanguageKotlinVersion}")
    modApi("net.fabricmc.fabric-api:fabric-api:${fabricApiVersion}")
    modApi("me.shedaniel:architectury-fabric:${architecturyApiVersion}")

    implementation(project(":common"))
}

tasks {
    for (task in listOf(jar, remapJar)) task.get().apply {
        archiveBaseName.set(rootProject.name)

        metaInf {
            from(rootDir) {
                include("LICENSE")
            }
        }

        from(project(":common").sourceSets.main.get().output,
             project(":common").sourceSets.main.get().resources
        )
    }

    processResources {
        filesMatching("fabric.mod.json") {
            expand(mutableMapOf(
                "modID"                       to modID,
                "version"                     to rootProject.version,
                "modName"                     to modName,
                "description"                 to description,
                "uname"                       to uname,
                "jvmVersion"                  to jvmVersion,
                "architecturyApiVersion"      to architecturyApiVersion,
                "fabricLoaderVersion"         to fabricLoaderVersion,
                "fabricApiVersion"            to fabricApiVersion,
                "fabricLanguageKotlinVersion" to fabricLanguageKotlinVersion
            ))
        }
    }
}

