package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Artist(data: FakerData) : FakerComponent(data) {
    fun name(): String {
        return fetch("artist.names")
    }
}
