import java.util.Properties

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    `java-library`
    `maven-publish`
    signing
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    id("org.jlleitschuh.gradle.ktlint") version "11.4.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.yaml:snakeyaml:2.2")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("io.mockk:mockk:1.13.3")
}

group = "io.bloco"
version = "2.0.4"

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            pom {
                name.set("Faker")
                description.set("Generates fake data for testing or populating a development database. A Kotlin port of the Faker ruby gem that's suitable to use in Android development.")
                url.set("https://github.com/blocoio/faker")
                licenses {
                    license {
                        name.set("MIT license")
                        url.set("https://github.com/blocoio/faker/blob/master/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("Bloco")
                        name.set("Bloco")
                        email.set("info@bloco.io")
                    }
                }
                scm {
                    connection.set("scm:git:github.com/blocoio/faker")
                    developerConnection.set("scm:git:github.com/blocoio/faker")
                    url.set("https://github.com/blocoio/faker")
                }
            }
        }
    }
}

val localProperties = Properties().apply {
    try {
        load(rootProject.file("local.properties").reader())
    } catch (e: Exception) {
        println("File local.properties not found.")
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))

            val sonatypeUsername = localProperties["sonatypeUsername"] as String?
            val sonatypePassword = localProperties["sonatypePassword"] as String?

            if (sonatypeUsername != null && sonatypePassword != null) {
                username.set(sonatypeUsername)
                password.set(sonatypePassword)
            } else {
                println("Sonatype credentials not found.")
            }
        }
    }
}

signing {
    val signingKey = localProperties["signingKey"] as String?
    val signingPassword = localProperties["signingPassword"] as String?

    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(publishing.publications)
    } else {
        println("Signing credentials not found.")
    }
}
