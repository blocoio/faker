package io.bloco.faker.components

import io.bloco.faker.Faker
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BookTest {
    private lateinit var faker: Faker
    @Before
    fun setUp() {
        faker = Faker()
    }

    @Test
    fun title() {
        Assert.assertNotNull(faker.book.title())
    }

    @Test
    fun author() {
        Assert.assertNotNull(faker.book.author())
    }

    @Test
    fun publisher() {
        Assert.assertNotNull(faker.book.publisher())
    }

    @Test
    fun genre() {
        Assert.assertNotNull(faker.book.genre())
    }
}