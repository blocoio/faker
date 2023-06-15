package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertEquals
import org.junit.Test

class BoolTest {
    private val faker = Faker()

    @Test
    fun bool() {
        val trueRatio = (Math.random() * 10).toFloat() / 10f
        val times = 1000
        val trueCounter = (0 until times).count { faker.bool.bool(trueRatio) }
        val actualRatio = trueCounter.toFloat() / times
        assertEquals(actualRatio.toDouble(), trueRatio.toDouble(), 0.1)
    }
}
