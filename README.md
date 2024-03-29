<img src="bloco_faker.png" alt="Faker" />

[![Release](https://img.shields.io/github/release/blocoio/faker.svg?label=Maven)](http://144.217.6.255/nexus/r/io.bloco/faker?server=https%3A%2F%2Fs01.oss.sonatype.org)

Generates fake data for testing or populating a development database.
Run your tests with realistic data like names, emails, dates, countries...

A Kotlin port of the [Faker ruby gem](https://github.com/stympy/faker/) that's suitable to use in Android development.
The goal is to reuse their locale data files without changes.

## Installing

```groovy
repositories {
    // ...
    mavenCentral()
}

dependencies {
    implementation 'io.bloco:faker:${fakerVersion}'
}
```

You can use ```testImplementation``` or ```androidTestImplementation```, if you only want to use Faker for testing.

## Usage

```kotlin
val faker = Faker()
faker.name.firstName()    // Returns "Aaron"
faker.company.name()      // Returns "Hirthe-Ritchie"

val faker = Faker("nl")
faker.name.firstName()    // Returns "Thijs"
```

For full list of available options, check the [original source](https://github.com/stympy/faker/blob/master/README.md).
We have tried to keep the operations as close as possible.

You can also check our [blog post](https://www.bloco.io/blog/faker-a-library-to-generate-fake-data-for-java-android).

### Available components

 - Address
 - App
 - Artist
 - Avatar
 - Book
 - Bool
 - Business
 - Color
 - Commerce
 - Company
 - Date
 - Food
 - Internet
 - Lorem
 - Name
 - Number
 - PhoneNumber
 - Placeholdit
 - SlackEmoji
 - Team
 - Time
 - University

### Warnings

 - Currently, we don't support locale specific operations
 like ```Address.postcode_by_state``` or ```Business.swedish_organisation_number```.

## Proguard

If you are using R8, the shrinking and obfuscation rules are included automatically.

Otherwise, you will need to add the following options:

```
-keep class org.yaml.snakeyaml.** { public protected private *; }
-keep class org.yaml.snakeyaml.** { public protected private *; }
-dontwarn org.yaml.snakeyaml.**
```

## Contact

Feedback and contributions are welcome.
Feel free to send an [email](mailto:hello@bloco.io) or submit a pull request.
