package io.bloco.faker.components

import io.bloco.faker.Faker
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AppTest {
    private lateinit var faker: Faker
    @Before
    fun setUp() {
        faker = Faker()
    }

    @Test
    fun name() {
        Assert.assertNotNull(faker.app.name())
    }

    @Test
    fun version() {
        Assert.assertNotNull(faker.app.version())
    }

    @Test
    fun author() {
        Assert.assertNotNull(faker.app.author())
    }
}