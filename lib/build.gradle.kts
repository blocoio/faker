plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    `java-library`
    `maven-publish`
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.github.bmoliveira:snake-yaml:v1.18-android")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("io.mockk:mockk:1.13.3")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.bloco"
            artifactId = "faker"
            version = "2.0.0"

            from(components["java"])
        }
    }
}