package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.MathHelper
import kotlin.math.pow

class Color(data: FakerData) : FakerComponent(data) {
    private val mathHelper: MathHelper = MathHelper()

    fun hexColor(): String {
        return String.format("#%06x", randomHelper.number(MAX_RGB.toDouble().pow(3.0).toInt()))
    }

    fun colorName(): String {
        return fetch("color.name")
    }

    fun singleRgbColor(): Int {
        return randomHelper.number(MAX_RGB)
    }

    fun rgbColor(): IntArray {
        return intArrayOf(singleRgbColor(), singleRgbColor(), singleRgbColor())
    }

    fun singleHslColor(): Double {
        return mathHelper.round(randomHelper.range(0.0, MAX_HSL), 2)
    }

    fun alphaChannel(): Double {
        return randomHelper.randDouble()
    }

    fun hslColor(): DoubleArray {
        return doubleArrayOf(singleHslColor(), singleHslColor(), singleHslColor())
    }

    fun hslaColor(): DoubleArray {
        return doubleArrayOf(singleHslColor(), singleHslColor(), singleHslColor(), alphaChannel())
    }

    companion object {
        const val MAX_RGB = 256
        const val MAX_HSL = 360.0
    }
}