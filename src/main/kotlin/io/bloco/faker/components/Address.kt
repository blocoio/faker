package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Address(data: FakerData) : FakerComponent(data) {
    fun cityPrefix(): String {
        return fetch("address.city_prefix")
    }

    fun citySuffix(): String {
        return fetch("address.city_suffix")
    }

    fun country(): String {
        return fetch("address.country")
    }

    fun countryCode(): String {
        return fetch("address.country_code")
    }

    fun buildingNumber(): String {
        return numerify(fetch("address.building_number"))
    }

    fun streetSuffix(): String {
        return fetch("address.street_suffix")
    }

    fun secondaryAddress(): String {
        return fetch("address.secondary_address")
    }

    fun postcode(): String {
        return numerify(fetch("address.postcode"))
    }

    fun state(): String {
        return fetch("address.state")
    }

    fun stateAbbr(): String {
        return fetch("address.state_abbr")
    }

    fun timeZone(): String {
        return fetch("address.time_zone")
    }

    fun city(): String {
        return parse(fetch("address.city"))
    }

    fun streetName(): String {
        return parse(fetch("address.street_name"))
    }

    fun streetAddress(): String {
        return parse(fetch("address.street_address"))
    }

    fun defaultCountry(): String {
        return fetch("address.default_country")
    }
}
