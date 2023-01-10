package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class PhoneNumberTest {
    private lateinit var faker: Faker
    @Before
    fun setUp() {
        faker = Faker("en-US")
    }

    @Test
    fun phoneNumber() {
        assertNotNull(faker.phoneNumber.phoneNumber())
    }

    @Test
    fun cellPhone() {
        assertNotNull(faker.phoneNumber.cellPhone())
    }

    @Test
    fun areaCode() {
        assertNotNull(faker.phoneNumber.areaCode())
    }

    @Test
    fun exchangeCode() {
        assertNotNull(faker.phoneNumber.exchangeCode())
    }

    @Test
    fun subscriberNumberDefault() {
        assertNotNull(faker.phoneNumber.subscriberNumber())
    }

    @Test
    fun subscriberNumber() {
        assertTrue(faker.phoneNumber.subscriberNumber(10).length == 10)
    }

    @Test
    fun extensionDefault() {
        assertNotNull(faker.phoneNumber.subscriberNumber())
    }

    @Test
    fun extension() {
        assertTrue(faker.phoneNumber.extension(10).length == 10)
    }
}