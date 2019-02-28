# Faker

Generates fake data for testing or populating a development database.
Run your tests with realistic data like names, emails, dates, countries...

A Java port of the [Faker ruby gem](https://github.com/stympy/faker/).
The goal was to reuse their locale data files.

[![Build Status](https://travis-ci.org/blocoio/faker.svg?branch=master)](https://travis-ci.org/blocoio/faker)
[![Release](https://img.shields.io/github/release/blocoio/faker.svg?label=maven)](https://jitpack.io/#blocoio/faker)

## Installing

    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }

    dependencies {
        compile 'com.github.blocoio:faker:1.2.8'
    }

You can use ```testCompile``` or ```androidTestCompile```, if you only want to use Faker for testing.

## Usage

    Faker faker = new Faker();
    faker.name.firstName();    // Returns "Aaron"
    faker.company.name();      // Returns "Hirthe-Ritchie"

    Faker faker = new Faker("nl");
    faker.name.firstName();    // Returns "Thijs"

For full list of available options, check the [original source](https://github.com/stympy/faker/blob/master/README.md).
We have tried to keep the operations as close as possible.

### Available components

 - Address
 - App
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

 - Currently we don't support locale specific operations
 like ```Address.postcode_by_state``` or ```Business.swedish_organisation_number```.

## TODO

 - Implement remaining components of the [Faker ruby gem](https://github.com/stympy/faker/).

## Proguard

To use Faker with proguard, here are the rules you need to add:

    # SnakeYAML
    -keep class org.yaml.snakeyaml.** { public protected private *; }
    -keep class org.yaml.snakeyaml.** { public protected private *; }
    -dontwarn org.yaml.snakeyaml.**
    
    # Joda Time
    -dontwarn org.joda.convert.**
    -dontwarn org.joda.time.**
    -keep class org.joda.time.** { *; }
    -keep interface org.joda.time.** { *; }


## Contact

Feedback and contributions are welcome.
Feel free to send an [email](mailto:hello@bloco.io) or submit a pull request.

## License

This code is free to use under the terms of the [MIT license](http://opensource.org/licenses/MIT).
