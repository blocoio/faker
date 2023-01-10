package io.bloco.faker.components

import io.bloco.faker.Faker
import io.bloco.faker.helpers.Period
import io.bloco.faker.helpers.toLocalDateTime
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.time.LocalDateTime

class TimeTest {
    private lateinit var faker: Faker
    private lateinit var formatter: SimpleDateFormat

    @Before
    fun setUp() {
        faker = Faker()
        formatter = SimpleDateFormat("yyyy-MM-dd")
    }

    @Test
    fun between() {
        val from = formatter.parse("1990-06-22")
        val to = formatter.parse("1990-06-23")
        val between = faker.time.between(from, to).toLocalDateTime()

        assertTrue(between.isAfter(from.toLocalDateTime()))
        assertTrue(between.isBefore(to.toLocalDateTime()))
    }

    @Test
    fun forward() {
        val now = LocalDateTime.now()
        val tenDaysLater = faker.time.forward(10).toLocalDateTime()
        assertTrue(tenDaysLater.dayOfMonth == now.plusDays(10).dayOfMonth)
    }

    @Test
    fun backward() {
        val now = LocalDateTime.now()
        val tenDaysBefore = faker.time.backward(10).toLocalDateTime()
        assertTrue(tenDaysBefore.dayOfMonth == now.minusDays(10).dayOfMonth)
    }

    @Test
    fun allPeriod() {
        val allPeriod = faker.time.forward(1, Period.all).toLocalDateTime()
        assertTrue(allPeriod.hour in 0..23)
    }

    @Test
    fun dayPeriod() {
        val dayPeriod = faker.time.forward(1, Period.day).toLocalDateTime()
        assertTrue(dayPeriod.hour in 9..17)
    }

    @Test
    fun nightPeriod() {
        val nightPeriod = faker.time.forward(1, Period.night).toLocalDateTime()
        assertTrue(nightPeriod.hour in 18..23)
    }

    @Test
    fun morningPeriod() {
        val morningPeriod = faker.time.forward(1, Period.morning).toLocalDateTime()
        assertTrue(morningPeriod.hour in 6..11)
    }

    @Test
    fun afternoonPeriod() {
        val afternoonPeriod = faker.time.forward(1, Period.afternoon).toLocalDateTime()
        assertTrue(afternoonPeriod.hour in 12..17)
    }

    @Test
    fun eveningPeriod() {
        val eveningPeriod = faker.time.forward(1, Period.evening).toLocalDateTime()
        assertTrue(eveningPeriod.hour in 17..21)
    }

    @Test
    fun midnightPeriod() {
        val midnightPeriod = faker.time.forward(1, Period.midnight).toLocalDateTime()
        assertTrue(midnightPeriod.hour in 0..4)
    }
}