package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.RandomHelper

class Company(data: FakerData) : FakerComponent(data) {
    fun name(): String {
        return parse(fetch("company.name"))
    }

    private fun prefix(): String {
        return fetch("company.prefix")
    }

    fun suffix(): String {
        return fetch("company.suffix")
    }

    fun industry(): String {
        return fetch("company.industry")
    }

    fun catchPhrase(): String {
        val buzzwordsSections = getList("company", "buzzwords")
        return buzzwordsSections.joinToString(" ") { buzzwordSection ->
            sampleFromList(buzzwordSection as List<*>)
        }
    }

    fun buzzwords(): String {
        return fetch("company.buzzwords")
    }

    fun bs(): String {
        return fetch("company.bs")
    }

    fun logo(): String {
        val randomNum = RandomHelper.range(1, 12)
        return "https://pigment.github.io/fake-logos/logos/medium/color/$randomNum.png"
    }

    fun profession(): String {
        return fetch("company.profession")
    }
}
