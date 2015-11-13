# Faker

*Work in progress*

Generates fake data for testing or populating a development database.

A Java port of the [Faker ruby gem](https://github.com/stympy/faker/).

[![Build Status](https://travis-ci.org/blocoio/faker.svg?branch=master)](https://travis-ci.org/blocoio/faker)
[![Coverage Status](https://coveralls.io/repos/blocoio/faker/badge.svg?branch=master&service=github)](https://coveralls.io/github/blocoio/faker?branch=master)

## Installing

    repositories {
        // ...
        maven { url "https://jitpack.io" }
    }

    dependencies {
        compile 'com.github.blocoio:faker:-SNAPSHOT'
    }

## Usage

    Faker faker = new Faker();
    faker.name.firstName();    // Returns "Aaron"
    faker.company.name();      // Returns "Hirthe-Ritchie"

    Faker faker = new Faker("nl");
    faker.name.firstName();    // Returns "Thijs"

For full list of available options, check the [original source](https://github.com/stympy/faker/blob/master/README.md).

### Available components

 - Address
 - App
 - Company
 - Name

## TODO

 - Dates support
 - Regular expressions support
 - Implement remaining components
