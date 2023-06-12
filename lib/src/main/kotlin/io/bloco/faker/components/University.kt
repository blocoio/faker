package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class University(data: FakerData) : FakerComponent(data) {
    fun name(): String {
        return parse(fetch("university.name"))
    }

    fun prefix(): String {
        return fetch("university.prefix")
    }

    fun suffix(): String {
        return fetch("university.suffix")
    }
}
