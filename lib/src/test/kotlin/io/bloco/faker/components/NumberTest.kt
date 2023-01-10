package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class NumberTest {
    private lateinit var faker: Faker

    @Before
    fun setUp() {
        faker = Faker()
    }

    @Test
    fun number() {
        assertTrue(faker.number.number(1).matches(Regex("\\d")))
        assertTrue(faker.number.number(5).matches(Regex("[1-9]\\d{4}")))
    }

    @Test
    fun leadingZeroNumber() {
        assertTrue(faker.number.leadingZeroNumber(1).matches(Regex("\\d")))
        assertTrue(faker.number.leadingZeroNumber(5).matches(Regex("\\d{5}")))
    }

    @Test
    fun decimalPart() {
        assertTrue(faker.number.decimalPart(1).matches(Regex("\\d")))
        assertTrue(faker.number.decimalPart(5).matches(Regex("\\d{4}[1-9]")))
    }

    @Test
    fun decimal() {
        assertTrue(faker.number.decimal(4).matches(Regex("[1-9]\\d{3}\\.\\d[1-9]")))
        assertTrue(faker.number.decimal(1, 4).matches(Regex("\\d\\.\\d{3}[1-9]")))
    }

    @Test
    fun digit() {
        assertTrue(faker.number.digit().matches(Regex("\\d")))
    }

    @Test
    fun nonZeroDigit() {
        assertTrue(faker.number.nonZeroDigit().matches(Regex("[1-9]")))
    }

    @Test
    fun hexadecimal() {
        assertTrue(faker.number.hexadecimal(1).matches(Regex("[0-9a-f]")))
        assertTrue(faker.number.hexadecimal(10).matches(Regex("[0-9a-f]{10}")))
    }

    @Test
    fun betweenDefault() {
        assertNotNull(faker.number.between())
    }

    @Test
    fun betweenInt() {
        assertTrue(faker.number.between(1, 2) in 1..2)
        assertTrue(faker.number.between(1, 10) in 1..10)
    }

    @Test
    fun betweenDouble() {
        assertTrue(faker.number.between(1.0, 2.0) in 1.0..2.0)
        assertTrue(faker.number.between(-1000, 1000) in -1000..1000)
    }

    @Test
    fun positiveDefault() {
        assertNotNull(faker.number.positive())
    }

    @Test
    fun positive() {
        assertTrue(faker.number.positive(1, 2) in 1..2)
        assertTrue(faker.number.positive(-1000.0, 1000.0) in 0.0..1000.0)
    }

    @Test
    fun negativeDefault() {
        assertNotNull(faker.number.negative())
    }

    @Test
    fun negative() {
        assertTrue(faker.number.negative(-1, -1) in -2..-1)
        assertTrue(faker.number.negative(-1000.0, 1000.0) in -1000.0..0.0)
    }
}