plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "2.0.0"
    id("org.flywaydb.flyway") version "8.5.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val ktorVersion = "2.3.12"

dependencies {
    runtimeOnly("com.squareup.moshi:moshi:1.14.0")
    runtimeOnly("com.squareup.moshi:moshi-kotlin:1.14.0")
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:1.7.0")
    implementation("org.postgresql:postgresql:42.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.exposed:exposed-core:0.50.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.50.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.50.1")
    implementation("org.jetbrains.exposed:exposed-json:0.50.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.50.1")
    implementation("org.xerial:sqlite-jdbc:3.46.0.0")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

flyway {
    url = "jdbc:postgresql://localhost:5432/university"
    user = "otus"
    password = "otus"
}