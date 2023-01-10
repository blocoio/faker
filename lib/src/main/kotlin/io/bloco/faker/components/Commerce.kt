package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode

class Commerce(data: FakerData) : FakerComponent(data) {
    fun color(): String {
        return call("color.colorName")
    }

    fun department(max: Int = 3, fixedAmount: Boolean = false): String {
        val num: Int = if (fixedAmount) {
            max
        } else {
            1 + randomHelper.number(max)
        }
        val categories = getCategories(num)
        return if (num > 1) {
            mergeCategories(categories)
        } else {
            categories[0]
        }
    }

    fun productName(): String {
        return (fetch("commerce.product_name.adjective")
                + " " + fetch("commerce.product_name.material")
                + " " + fetch("commerce.product_name.product"))
    }

    fun material(): String {
        return fetch("commerce.product_name.material")
    }

    fun price(min: Int = 0, max: Int = 100): BigDecimal {
        return BigDecimal(randomHelper.range(min, max))
            .round(MathContext(2, RoundingMode.HALF_UP))
    }

    fun promotionCode(digits: Int = 6): String {
        return (fetch("commerce.promotion_code.adjective")
                + fetch("commerce.promotion_code.noun")
                + getComponent(Number::class.java).number(digits))
    }

    // Helpers
    private fun getCategories(num: Int): List<String> {
        val categories: MutableList<String> = ArrayList(num)
        while (categories.size != num) {
            val category = fetch("commerce.department")
            if (!categories.contains(category)) {
                categories.add(category)
            }
        }
        return categories
    }

    private fun mergeCategories(categories: List<String>): String {
        val commaCategories = categories.subList(0, categories.size - 1)
        val commaSeparated = stringHelper.join(commaCategories, ", ")
        return commaSeparated + separator + categories[categories.size - 1]
    }
}