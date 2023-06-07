package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Team(data: FakerData) : FakerComponent(data) {
    fun name(): String {
        return parse(fetch("team.name"))
    }

    fun creature(): String {
        return fetch("team.creature")
    }

    fun state(): String {
        return call("address.state")
    }

    fun sport(): String {
        return fetch("team.sport")
    }
}