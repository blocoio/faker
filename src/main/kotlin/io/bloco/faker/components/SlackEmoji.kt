package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class SlackEmoji(data: FakerData) : FakerComponent(data) {
    fun people(): String {
        return fetch("slack_emoji.people")
    }

    fun nature(): String {
        return fetch("slack_emoji.nature")
    }

    fun foodAndDrink(): String {
        return fetch("slack_emoji.food_and_drink")
    }

    fun celebration(): String {
        return fetch("slack_emoji.celebration")
    }

    fun activity(): String {
        return fetch("slack_emoji.activity")
    }

    fun travelAndPlaces(): String {
        return fetch("slack_emoji.travel_and_places")
    }

    fun objectsAndSymbols(): String {
        return fetch("slack_emoji.objects_and_symbols")
    }

    fun custom(): String {
        return fetch("slack_emoji.custom")
    }

    fun emoji(): String {
        return parse(fetch("slack_emoji.emoji"))
    }
}
