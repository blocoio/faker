package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.RandomHelper

class Color(data: FakerData) : FakerComponent(data) {
    fun hexColor(): String {
        return "#%06x".format(RandomHelper.number(MAX_RGB * MAX_RGB * MAX_RGB))
    }

    fun colorName(): String {
        return fetch("color.name")
    }

    fun singleRgbColor(): Int {
        return RandomHelper.number(MAX_RGB)
    }

    fun rgbColor(): IntArray {
        return IntArray(3) { singleRgbColor() }
    }

    fun singleHslColor(): Double {
        return RandomHelper.range(0.0, MAX_HSL)
    }

    fun alphaChannel(): Double {
        return RandomHelper.randDouble()
    }

    fun hslColor(): DoubleArray {
        return DoubleArray(3) { singleHslColor() }
    }

    fun hslaColor(): DoubleArray {
        return hslColor() + alphaChannel()
    }

    companion object {
        const val MAX_RGB = 256
        const val MAX_HSL = 360.0
    }
}
