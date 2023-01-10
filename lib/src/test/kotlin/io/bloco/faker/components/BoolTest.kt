package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import kotlin.math.roundToInt

class BoolTest {
    private lateinit var faker: Faker
    @Before
    fun setUp() {
        faker = Faker()
    }

    @Test
    fun bool() {
        val trueRatio = (Math.random() * 10f).roundToInt() / 10f
        val times = 1000
        var trueCounter = 0
        for (i in 0 until times) {
            if (faker.bool.bool(trueRatio)) {
                trueCounter++
            }
        }
        TestCase.assertEquals((trueCounter / times.toFloat()).toDouble(), trueRatio.toDouble(), 0.1)
    }
}