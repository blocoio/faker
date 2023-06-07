package io.bloco.faker.helpers

import java.security.SecureRandom
import kotlin.math.abs
import kotlin.math.pow

class RandomHelper {
    private val random: SecureRandom = SecureRandom()

    fun <T> sample(options: List<T>): T {
        return options[random.nextInt(options.size)]
    }

    fun digit(): String {
        return random.nextInt(10).toString()
    }

    fun randBoolean(): Boolean {
        return random.nextBoolean()
    }

    fun number(max: Int): Int {
        return random.nextInt(max)
    }

    fun number(max: Long): Long {
        return if (max != 0L) abs(random.nextLong()) % max else 0
    }

    fun numberByLength(length: Int): Int {
        return random.nextInt(10.0.pow(length.toDouble()).toInt())
    }

    fun range(min: Int, max: Int): Int {
        var tempMin = min
        var tempMax = max
        if (tempMin == tempMax) {
            return tempMin
        }
        if (tempMax < tempMin) {
            val temp = tempMax
            tempMax = tempMin
            tempMin = temp
        }
        return number(tempMax - tempMin + 1) + tempMin
    }

    fun range(min: Long, max: Long): Long {
        var tempMin = min
        var tempMax = max
        if (tempMin == tempMax) {
            return tempMin
        }
        if (tempMax < tempMin) {
            val temp = tempMax
            tempMax = tempMin
            tempMin = temp
        }
        return number(tempMax - tempMin + 1) + tempMin
    }

    fun range(min: Double, max: Double): Double {
        var tempMin = min
        var tempMax = max
        if (tempMax < tempMin) {
            val temp = tempMax
            tempMax = tempMin
            tempMin = temp
        }
        return random.nextDouble() * (tempMax - tempMin) + tempMin
    }

    fun randDouble(): Double {
        return random.nextDouble()
    }
}