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
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.github.bmoliveira:snake-yaml:v1.18-android")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("io.mockk:mockk:1.13.3")
}

group = "io.bloco"
version = "2.0.1"

java {
    withSourcesJar()
    withJavadocJar()
}

nexusPublishing {
    repositories {
        sonatype {
            val sonatypeUsername: String? by project
            val sonatypePassword: String? by project

            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
            username.set(sonatypeUsername ?: System.getenv("SONATYPE_USERNAME"))
            password.set(sonatypePassword ?: System.getenv("SONATYPE_PASSWORD"))
        }
    }
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

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}
