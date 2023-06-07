package io.bloco.faker

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

class FakerTest {
    @Test
    fun testLoadComponents() {
        val faker = Faker()
        assertNotNull(faker.app)
    }

    @Test
    fun testLocaleDefault() {
        val faker = Faker()
        assertTrue(faker.locale == Faker.DEFAULT_LOCALE)
    }

    @Test
    fun testLocaleProvided() {
        val faker = Faker("nl")
        assertTrue(faker.locale == "nl")
    }

    @Test(expected = IllegalArgumentException::class)
    fun testLocaleInvalid() {
        Faker("invalid-locale")
    }

    @Test
    fun testLocaleFallback() {
        // Dutch doesn't have App.name, but English (the default) has
        val faker = Faker("nl")
        assertNotNull(faker.app.name())
        assertNotNull(faker.company.name())
    }
}