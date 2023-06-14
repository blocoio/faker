package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.RandomHelper
import java.time.LocalDate

class Business(data: FakerData) : FakerComponent(data) {
    fun creditCardNumber(): String {
        return fetch("business.credit_card_numbers")
    }

    fun creditCardExpireDate(): LocalDate {
        return LocalDate.now()
            .plusYears(RandomHelper.number(CREDIT_CARD_PLUS_YEARS_MAX).toLong() + 1)
    }

    fun creditCardType(): String {
        return fetch("business.credit_card_types")
    }

    companion object {
        private const val CREDIT_CARD_PLUS_YEARS_MAX = 4
    }
}
