package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Company(data: FakerData) : FakerComponent(data) {
    fun name(): String {
        return parse(fetch("company.name"))
    }

    fun suffix(): String {
        return fetch("company.suffix")
    }

    fun industry(): String {
        return fetch("company.industry")
    }

    fun catchPhrase(): String {
        val buzzwordsSections = getList("company", "buzzwords")
        var catchPhrase = ""
        for (buzzwordsSection in buzzwordsSections) {
            catchPhrase += sampleFromList(buzzwordsSection as List<Any>) + " "
        }
        return catchPhrase.substring(0, catchPhrase.length - 1)
    }

    fun buzzwords(): String {
        return fetch("company.buzzwords")
    }

    fun bs(): String {
        return fetch("company.bs")
    }

    fun logo(): String {
        val randomNum = randomHelper.range(1, 12)
        return "https://pigment.github.io/fake-logos/logos/medium/color/$randomNum.png"
    }

    fun profession(): String {
        return fetch("company.profession")
    }
}