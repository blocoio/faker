package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import java.math.BigDecimal
import java.math.RoundingMode

class Commerce(data: FakerData) : FakerComponent(data) {
    fun color(): String {
        return call("color.colorName")
    }

    @JvmOverloads
    fun department(max: Int = 3, fixedAmount: Boolean = false): String {
        val num = if (fixedAmount) max else randomHelper.number(max) + 1
        val categories = getCategories(num)
        return if (num > 1) mergeCategories(categories) else categories.first()
    }

    fun productName(): String {
        return listOf(
            fetch("commerce.product_name.adjective"),
            fetch("commerce.product_name.material"),
            fetch("commerce.product_name.product")
        ).joinToString(" ")
    }

    fun material(): String {
        return fetch("commerce.product_name.material")
    }

    @JvmOverloads
    fun price(min: Int = 0, max: Int = 100): BigDecimal {
        return BigDecimal(randomHelper.range(min, max)).setScale(2, RoundingMode.HALF_UP)
    }

    @JvmOverloads
    fun promotionCode(digits: Int = 6): String {
        return listOf(
            fetch("commerce.promotion_code.adjective"),
            fetch("commerce.promotion_code.noun"),
            getComponent(Number::class).number(digits)
        ).joinToString("")
    }

    // Helpers
    private fun getCategories(num: Int): List<String> {
        return generateSequence { fetch("commerce.department") }
            .distinct()
            .take(num)
            .toList()
    }

    private fun mergeCategories(categories: List<String>): String {
        val commaSeparated = categories.take(categories.size - 1).joinToString(", ")
        return commaSeparated + separator + categories.last()
    }
}
