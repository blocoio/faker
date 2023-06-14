package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class PlaceholditTest {
    private val faker = Faker()

    @Test
    fun imageDefault() {
        val defaultUrl = faker.placeholdit.image()
        assertTrue(defaultUrl.contains("placehold.it"))
        assertTrue(defaultUrl.contains("300x300"))
        assertTrue(defaultUrl.contains("png"))
        assertFalse(defaultUrl.contains("text"))
    }

    @Test
    fun imageParams() {
        val specificUrl = faker.placeholdit.image("80x80", "gif", "F0F", "0F0", "blah")
        assertTrue(specificUrl.contains("placehold.it"))
        assertTrue(specificUrl.contains("80x80"))
        assertTrue(specificUrl.contains("gif"))
        assertTrue(specificUrl.contains("F0F"))
        assertTrue(specificUrl.contains("0F0"))
        assertTrue(specificUrl.contains("blah"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun imageInvalidSize() {
        faker.placeholdit.image("123456")
    }

    @Test(expected = IllegalArgumentException::class)
    fun imageInvalidFormat() {
        faker.placeholdit.image("80x80", "pdf")
    }

    @Test(expected = IllegalArgumentException::class)
    fun imageInvalidBackgroundColor() {
        faker.placeholdit.image("80x80", "gif", "###")
    }

    @Test(expected = IllegalArgumentException::class)
    fun imageTextColorWithoutBackgroundColor() {
        faker.placeholdit.image("80x80", "gif", null, "000")
    }

    @Test(expected = IllegalArgumentException::class)
    fun imageInvalidTextColor() {
        faker.placeholdit.image("80x80", "gif", "999", "###")
    }
}
