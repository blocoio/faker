package io.bloco.faker.components

import io.bloco.faker.Faker
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AddressTest {
    private lateinit var faker: Faker
    @Before
    fun setUp() {
        faker = Faker()
    }

    @Test
    fun testCityPrefix() {
        Assert.assertNotNull(faker.address.cityPrefix())
    }

    @Test
    fun citySuffix() {
        Assert.assertNotNull(faker.address.citySuffix())
    }

    @Test
    fun country() {
        Assert.assertNotNull(faker.address.country())
    }

    @Test
    fun countryCode() {
        Assert.assertNotNull(faker.address.countryCode())
    }

    @Test
    fun buildingNumber() {
        Assert.assertNotNull(faker.address.buildingNumber())
    }

    @Test
    fun streetSuffix() {
        Assert.assertNotNull(faker.address.streetSuffix())
    }

    @Test
    fun secondaryAddress() {
        Assert.assertNotNull(faker.address.secondaryAddress())
    }

    @Test
    fun postcode() {
        Assert.assertNotNull(faker.address.postcode())
    }

    @Test
    fun state() {
        Assert.assertNotNull(faker.address.state())
    }

    @Test
    fun stateAbbr() {
        Assert.assertNotNull(faker.address.stateAbbr())
    }

    @Test
    fun timeZone() {
        Assert.assertNotNull(faker.address.timeZone())
    }

    @Test
    fun city() {
        Assert.assertNotNull(faker.address.city())
    }

    @Test
    fun streetName() {
        Assert.assertNotNull(faker.address.streetName())
    }

    @Test
    fun streetAddress() {
        Assert.assertNotNull(faker.address.streetAddress())
    }

    @Test
    fun defaultCountry() {
        Assert.assertNotNull(faker.address.defaultCountry())
    }
}