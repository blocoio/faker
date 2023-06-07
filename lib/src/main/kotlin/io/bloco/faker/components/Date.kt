package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.toDate
import io.bloco.faker.helpers.toLocalDate
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import java.util.Date
import kotlin.random.Random

class Date(fakerData: FakerData) : FakerComponent(fakerData) {
    private val formatter = SimpleDateFormat("yyyy-MM-dd")

    fun between(from: String, to: String): Date {
        return try {
            val fromDate = formatter.parse(from)
            val toDate = formatter.parse(to)
            between(fromDate, toDate)
        } catch (exception: ParseException) {
            throw RuntimeException(exception)
        }
    }

    fun between(from: Date, to: Date): Date {
        return between(from.toLocalDate(), to.toLocalDate())
    }

    @JvmOverloads
    fun forward(numberOfDays: Int = DEFAULT_NUM_OF_DAYS): Date {
        return between(today(), today().plusDays(numberOfDays.toLong()))
    }

    @JvmOverloads
    fun backward(numberOfDays: Int = DEFAULT_NUM_OF_DAYS): Date {
        return between(today().minusDays(numberOfDays.toLong()), today())
    }

    @JvmOverloads
    fun birthday(minAge: Int = DEFAULT_MIN_AGE, maxAge: Int = DEFAULT_MAX_AGE): Date {
        return between(today().plusYears(minAge.toLong()), today().plusYears(maxAge.toLong()))
    }

    // Helpers
    private fun between(from: LocalDate, to: LocalDate): Date {
        return getRandomDate(from, to)
    }

    private fun today(): LocalDate {
        return LocalDate.now()
    }

    private fun getRandomDate(from: LocalDate, to: LocalDate): Date {
        val diffInDays = ChronoUnit.DAYS.between(from, to)
        return from.plusDays(Random.nextLong(diffInDays)).toDate()
    }

    companion object {
        private const val DEFAULT_NUM_OF_DAYS = 365
        private const val DEFAULT_MIN_AGE = 18
        private const val DEFAULT_MAX_AGE = 65
    }
}