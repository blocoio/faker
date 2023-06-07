package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class AppTest {
    private val faker = Faker()

    @Test
    fun name() {
        assertNotNull(faker.app.name())
    }

    @Test
    fun version() {
        assertNotNull(faker.app.version())
    }

    @Test
    fun author() {
        assertNotNull(faker.app.author())
    }
}