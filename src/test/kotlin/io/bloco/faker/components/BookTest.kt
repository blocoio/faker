package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class BookTest {
    private val faker = Faker()

    @Test
    fun title() {
        assertNotNull(faker.book.title())
    }

    @Test
    fun author() {
        assertNotNull(faker.book.author())
    }

    @Test
    fun publisher() {
        assertNotNull(faker.book.publisher())
    }

    @Test
    fun genre() {
        assertNotNull(faker.book.genre())
    }
}
