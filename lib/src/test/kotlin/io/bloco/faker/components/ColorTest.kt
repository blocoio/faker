package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class ColorTest {
    private val faker = Faker()

    @Test
    fun hexColor() {
        assertTrue(faker.color.hexColor().matches(Regex("^#[0-9a-f]{6}\$")))
    }

    @Test
    fun color() {
        assertNotNull(faker.color.colorName())
    }

    @Test
    fun singleRgbColor() {
        assertSingleRgbColor(faker.color.singleRgbColor())
    }

    @Test
    fun rgbColor() {
        val color = faker.color.rgbColor()
        assertTrue(color.size == 3)
        assertSingleRgbColor(color[0])
        assertSingleRgbColor(color[1])
        assertSingleRgbColor(color[2])
    }

    @Test
    fun singleHslColor() {
        assertSingleHslColor(faker.color.singleHslColor())
    }

    @Test
    fun alphaChannel() {
        assertAlphaChannel(faker.color.alphaChannel())
    }

    @Test
    fun hslColor() {
        val color = faker.color.hslColor()
        assertTrue(color.size == 3)
        assertSingleHslColor(color[0])
        assertSingleHslColor(color[1])
        assertSingleHslColor(color[2])
    }

    @Test
    fun hslaColor() {
        val color = faker.color.hslaColor()
        assertTrue(color.size == 4)
        assertSingleHslColor(color[0])
        assertSingleHslColor(color[1])
        assertSingleHslColor(color[2])
        assertAlphaChannel(color[3])
    }

    private fun assertSingleRgbColor(singleRgbColor: Int) {
        assertTrue(singleRgbColor in 0..Color.MAX_RGB)
    }

    private fun assertSingleHslColor(singleHslColor: Double) {
        assertTrue(singleHslColor in 0.0..Color.MAX_HSL)
    }

    private fun assertAlphaChannel(alpha: Double) {
        assertTrue(alpha in 0.0..1.0)
    }
}