package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertFalse
import org.junit.Test
import kotlin.test.assertTrue

class AvatarTest {
    private val faker = Faker()

    @Test
    fun imageDefault() {
        val defaultUrl = faker.avatar.image()
        assertTrue(defaultUrl.contains("robohash.org"))
        assertTrue(defaultUrl.contains("image"))
        assertTrue(defaultUrl.contains("300x300"))
        assertTrue(defaultUrl.contains("png"))
        assertTrue(defaultUrl.contains("set1"))
        assertFalse(defaultUrl.contains("bgset"))
    }

    @Test
    fun imageParams() {
        val specificUrl = faker.avatar.image("my-slug", "80x80", "bmp", "set2", "bgset1")
        assertTrue(specificUrl.contains("robohash.org"))
        assertTrue(specificUrl.contains("my-slug"))
        assertTrue(specificUrl.contains("80x80"))
        assertTrue(specificUrl.contains("bmp"))
        assertTrue(specificUrl.contains("set2"))
        assertTrue(specificUrl.contains("bgset1"))
    }

    @Test(expected = IllegalArgumentException::class)
    fun imageInvalidSize() {
        faker.avatar.image("my-slug", "123456")
    }

    @Test(expected = IllegalArgumentException::class)
    fun imageInvalidFormat() {
        faker.avatar.image("my-slug", "80x80", "pdf")
    }
}