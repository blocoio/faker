package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class App(data: FakerData) : FakerComponent(data) {
    fun name(): String {
        return fetch("app.name")
    }

    fun version(): String {
        return numerify(fetch("app.version"))
    }

    fun author(): String {
        return parse(fetch("app.author"))
    }
}
