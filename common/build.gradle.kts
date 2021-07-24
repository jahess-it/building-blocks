val fabricLoaderVersion: String by rootProject
val architecturyApiVersion: String by rootProject

dependencies {
    modImplementation("net.fabricmc:fabric-loader:${fabricLoaderVersion}")
    modApi("me.shedaniel:architectury:${architecturyApiVersion}")
}

architectury {
    common()
}
