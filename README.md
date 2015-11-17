# Faker

Generates fake data for testing or populating a development database.
Run your tests with realistic data like names, emails, dates, countries...

A Java port of the [Faker ruby gem](https://github.com/stympy/faker/).
The goal was to reuse their locale data files.

[![Build Status](https://travis-ci.org/blocoio/faker.svg?branch=master)](https://travis-ci.org/blocoio/faker)

## Installing

``` groovy
    repositories {
        // ...
        maven { url 'https://jitpack.io' }
    }

    dependencies {
        compile 'com.github.blocoio:faker:1.0.0'
    }
```

## Usage

``` java
    Faker faker = new Faker();
    faker.name.firstName();    // Returns "Aaron"
    faker.company.name();      // Returns "Hirthe-Ritchie"
```
``` java
    Faker faker = new Faker("nl");
    faker.name.firstName();    // Returns "Thijs"
```

For full list of available options, check the [original source](https://github.com/stympy/faker/blob/master/README.md).
We have tried to keep the operations as close as possible.

### Available components

 - Address
 - App
 - Avatar
 - Book
 - Business
 - Color
 - Commerce
 - Company
 - Date
 - Internet
 - Lorem
 - Name
 - Number
 - PhoneNumber
 - SlackEmoji
 - Team
 - Time
 - University

### Warnings

 - Currently we don't support locale specific operations
 like ```Address.postcode_by_state``` or ```Business.swedish_organisation_number```.

## TODO

 - Implement remaining components:
   - Bitcoin
   - Code
   - Finance
   - Hacker
   - Hipster
   - IDNumber
   - Shakespeare

## Contact

Feedback and contributions are welcome.
Feel free to send an [email](mailto:hello@bloco.io) or submit a pull request.

## License

This code is free to use under the terms of the [MIT license](http://opensource.org/licenses/MIT).