package io.bloco.faker.components

import io.bloco.faker.Faker
import io.bloco.faker.helpers.toDate
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.text.SimpleDateFormat
import java.time.LocalDate

class DateTest {
    private val faker = Faker()
    private val formatter = SimpleDateFormat("yyyy-MM-dd")

    @Test
    @Throws(Exception::class)
    fun between() {
        val from = "1990-06-22"
        val to = "1990-06-23"
        val fromDate = formatter.parse(from)
        val toDate = formatter.parse(to)

        assertTrue(faker.date.between(from, to) in fromDate..toDate)
        assertTrue(faker.date.between(fromDate, toDate) in fromDate..toDate)
    }

    @Test
    fun forward() {
        val today = LocalDate.now().toDate()
        val tomorrow = LocalDate.now().plusDays(1).toDate()
        val in100Days = LocalDate.now().plusDays(100).toDate()

        assertTrue(faker.date.forward(1) in today..tomorrow)
        assertTrue(faker.date.forward(100) in today..in100Days)
    }

    @Test
    fun forwardDefault() {
        assertNotNull(faker.date.forward())
    }

    @Test
    fun backward() {
        val today = LocalDate.now().toDate()
        val yesterday = LocalDate.now().minusDays(1).toDate()
        val minus100Days = LocalDate.now().minusDays(100).toDate()

        assertTrue(faker.date.backward(1) in yesterday..today)
        assertTrue(faker.date.backward(100) in minus100Days..today)
    }

    @Test
    fun backwardDefault() {
        assertNotNull(faker.date.backward())
    }

    @Test
    fun birthday() {
        val nextYear = LocalDate.now().plusYears(1).toDate()
        val in10Years = LocalDate.now().plusYears(10).toDate()
        assertTrue(faker.date.birthday(1, 10) in nextYear .. in10Years)
    }

    @Test
    fun birthdayDefault() {
        assertNotNull(faker.date.birthday())
    }
}