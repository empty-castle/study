import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.plugin.noarg") version "1.7.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.7.21"
    kotlin("jvm") version "1.7.21"
    kotlin("plugin.jpa") version "1.7.21"
    application
}

group = "org.emptycastle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hibernate:hibernate-entitymanager:5.6.14.Final")
    implementation("com.oracle.database.jdbc:ojdbc8-production:21.7.0.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}