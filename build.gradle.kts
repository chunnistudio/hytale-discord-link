import groovy.json.JsonSlurper

plugins {
    id("idea")
    id("java")
    id("com.gradleup.shadow") version "9.3.0"
}

group = "studio.chunni"
val manifestFile = file("src/main/resources/manifest.json")
val manifestJson = JsonSlurper().parse(manifestFile) as Map<*, *>
val manifestVersion = manifestJson["Version"] as String

val isRelease: String? by project
version = if (isRelease == "true") {
    manifestVersion }
else {
    "$manifestVersion-SNAPSHOT"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(files("libs/HytaleServer.jar"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("club.minnced:discord-webhooks:0.8.4")
    implementation("org.slf4j:slf4j-simple:2.0.12")
    implementation("net.dv8tion:JDA:6.1.1")
}


tasks {
    shadowJar {
        archiveBaseName.set("hytale-discord-link")
        archiveClassifier.set("")
        archiveVersion.set(version.toString())
    }

}

tasks.test {
    useJUnitPlatform()
}