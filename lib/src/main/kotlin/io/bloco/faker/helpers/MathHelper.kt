package io.bloco.faker.helpers

import kotlin.math.pow
import kotlin.math.roundToInt

class MathHelper {
    fun round(number: Double, precision: Int): Double {
        val precisionPow = 10.0.pow(precision.toDouble())
        return (number * precisionPow).roundToInt() / precisionPow
    }
}