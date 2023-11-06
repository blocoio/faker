package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class AddressTest {
    private val faker = Faker()

    @Test
    fun testCityPrefix() {
        assertNotNull(faker.address.cityPrefix())
    }

    @Test
    fun citySuffix() {
        assertNotNull(faker.address.citySuffix())
    }

    @Test
    fun country() {
        assertNotNull(faker.address.country())
    }

    @Test
    fun countryCode() {
        assertNotNull(faker.address.countryCode())
    }

    @Test
    fun buildingNumber() {
        assertNotNull(faker.address.buildingNumber())
    }

    @Test
    fun streetSuffix() {
        assertNotNull(faker.address.streetSuffix())
    }

    @Test
    fun secondaryAddress() {
        assertNotNull(faker.address.secondaryAddress())
    }

    @Test
    fun postcode() {
        assertNotNull(faker.address.postcode())
    }

    @Test
    fun state() {
        assertNotNull(faker.address.state())
    }

    @Test
    fun stateAbbr() {
        assertNotNull(faker.address.stateAbbr())
    }

    @Test
    fun timeZone() {
        assertNotNull(faker.address.timeZone())
    }

    @Test
    fun city() {
        assertNotNull(faker.address.city())
    }

    @Test
    fun city_pt() {
        assertNotNull(Faker("pt").address.city())
    }

    @Test
    fun city_ru() {
        assertNotNull(Faker("ru").address.city())
    }

    @Test
    fun streetName() {
        assertNotNull(faker.address.streetName())
    }

    @Test
    fun streetAddress() {
        assertNotNull(faker.address.streetAddress())
    }

    @Test
    fun defaultCountry() {
        assertNotNull(faker.address.defaultCountry())
    }
}
