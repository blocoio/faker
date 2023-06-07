package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import kotlin.math.abs
import kotlin.math.pow

class Number(data: FakerData) : FakerComponent(data) {
    fun number(digits: Int): String {
        return leadingZeroNumber(digits)
    }

    fun leadingZeroNumber(digits: Int): String {
        return (1..digits).joinToString("") { digit() }
    }

    fun decimalPart(digits: Int): String {
        return leadingZeroNumber(digits - 1) + nonZeroDigit()
    }

    fun decimal(leftDigits: Int, rightDigits: Int = DEFAULT_DECIMAL_PART_DIGITS): String {
        return number(leftDigits) + "." + decimalPart(rightDigits)
    }

    fun digit(): String {
        return randomHelper.number(10).toString()
    }

    fun nonZeroDigit(): String {
        return (randomHelper.number(9) + 1).toString()
    }

    fun hexadecimal(digits: Int): String {
        if (digits < 1) {
            return ""
        }
        val num = randomHelper.number(16.0.pow(digits.toDouble()).toLong())
        return "%0${digits}x".format(num)
    }

    fun between(from: Int = DEFAULT_FROM, to: Int = DEFAULT_TO): Int {
        return randomHelper.range(from, to)
    }

    fun between(from: Long, to: Long): Long {
        return randomHelper.range(from, to)
    }

    fun between(from: Double, to: Double): Double {
        return randomHelper.range(from, to)
    }

    fun positive(from: Int = DEFAULT_FROM, to: Int = DEFAULT_TO): Int {
        return abs(between(from, to))
    }

    fun positive(from: Long, to: Long): Long {
        return abs(between(from, to))
    }

    fun positive(from: Double, to: Double): Double {
        return abs(between(from, to))
    }

    fun negative(from: Int = DEFAULT_FROM, to: Int = DEFAULT_TO): Int {
        return abs(between(from, to)) * -1
    }

    fun negative(from: Long, to: Long): Long {
        return abs(between(from, to)) * -1
    }

    fun negative(from: Double, to: Double): Double {
        return abs(between(from, to)) * -1
    }

    companion object {
        private const val DEFAULT_DECIMAL_PART_DIGITS = 2
        private const val DEFAULT_FROM = 1
        private const val DEFAULT_TO = 5000
    }
}