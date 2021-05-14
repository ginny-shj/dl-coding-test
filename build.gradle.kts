plugins {
    kotlin("jvm") version "1.4.32"
    groovy
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.codehaus.groovy:groovy:3.0.7")
    testImplementation(platform("org.spockframework:spock-bom:2.0-M4-groovy-3.0"))
    testImplementation("org.spockframework:spock-core")

    // logging
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("io.github.microutils:kotlin-logging:2.0.3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}






