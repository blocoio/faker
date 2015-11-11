# Faker

*Work in progress*

Generates fake data for testing or populating a development database.

A Java port of the [Faker ruby gem](https://github.com/stympy/faker/).

[![Build Status](https://travis-ci.org/blocoio/faker.svg?branch=master)](https://travis-ci.org/blocoio/faker)

## Installing

*Not available yet*

## Usage

    Faker faker = new Faker();
    faker.name.firstName();    // Returns "Aaron"
    faker.company.name();       // Returns "Hirthe-Ritchie"

For full list of available options, check the [original source](https://github.com/stympy/faker/blob/master/README.md).

### Available components

 - App
 - Company
 - Name

## TODO

 - Add all locales and test localization
 - Dates support
 - Implement remaining components
