package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.RandomHelper

class PhoneNumber(data: FakerData) : FakerComponent(data) {
    fun phoneNumber(): String {
        return numerify(parse(fetch("phone_number.formats")))
    }

    fun cellPhone(): String {
        return numerify(parse(fetch("cell_phone.formats")))
    }

    // US only
    fun areaCode(): String {
        return fetch("phone_number.area_code")
    }

    // US only
    fun exchangeCode(): String {
        return fetch("phone_number.exchange_code")
    }

    // US only
    fun subscriberNumber(): String {
        return subscriberNumber(DEFAULT_EXTENSION_LENGTH)
    }

    // US only
    fun subscriberNumber(length: Int): String {
        return "%0${length}d".format(RandomHelper.numberByLength(length))
    }

    // US only
    fun extension(): String {
        return subscriberNumber()
    }

    // US only
    fun extension(length: Int): String {
        return subscriberNumber(length)
    }

    companion object {
        private const val DEFAULT_EXTENSION_LENGTH = 4
    }
}
