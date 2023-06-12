package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.Period
import io.bloco.faker.helpers.toDate
import io.bloco.faker.helpers.toLocalDateTime
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.temporal.ChronoField
import java.util.Date

class Time(fakerData: FakerData) : FakerComponent(fakerData) {
    fun between(from: Date, to: Date, period: Period): Date {
        return between(from.toLocalDateTime(), to.toLocalDateTime(), period)
    }

    fun between(from: Date, to: Date): Date {
        return between(from, to, Period.All)
    }

    @JvmOverloads
    fun forward(numberOfDays: Int, period: Period = Period.All): Date {
        return randomTime(now(), period).plusDays(numberOfDays.toLong()).toDate()
    }

    @JvmOverloads
    fun backward(numberOfDays: Int, period: Period = Period.All): Date {
        return randomTime(now(), period).minusDays(numberOfDays.toLong()).toDate()
    }

    private fun now(): LocalDateTime {
        return LocalDateTime.now()
    }

    private fun between(from: LocalDateTime, to: LocalDateTime, period: Period): Date {
        return randomTime(getRandomTimeBetweenTwoDates(from, to).toLocalDateTime(), period).toDate()
    }

    private fun getRandomTimeBetweenTwoDates(from: LocalDateTime, to: LocalDateTime): Long {
        val toInMillis = to.toEpochSecond(ZoneOffset.UTC) * 1000 + to.get(ChronoField.MILLI_OF_SECOND)
        val fromInMillis = from.toEpochSecond(ZoneOffset.UTC) * 1000 + from.get(ChronoField.MILLI_OF_SECOND)
        val diff = toInMillis - fromInMillis + 1
        return fromInMillis + (Math.random() * diff).toLong()
    }

    private fun randomTime(dateTime: LocalDateTime, period: Period): LocalDateTime {
        return dateTime.withHour(hours(period))
            .withMinute(minutes())
            .withSecond(seconds())
    }

    private fun hours(period: Period): Int {
        val values: IntArray = period.values
        return values[randomHelper.number(values.size)]
    }

    private fun minutes(): Int {
        return randomHelper.number(60)
    }

    private fun seconds(): Int {
        return randomHelper.number(60)
    }
}
