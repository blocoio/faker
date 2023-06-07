package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Name(data: FakerData) : FakerComponent(data) {
    fun firstName(): String {
        return fetch("name.first_name")
    }

    fun lastName(): String {
        return fetch("name.last_name")
    }

    fun prefix(): String {
        return fetch("name.prefix")
    }

    fun suffix(): String {
        return fetch("name.suffix")
    }

    fun title(): String {
        return (fetch("name.title.descriptor")
                + " " + fetch("name.title.level")
                + " " + fetch("name.title.job"))
    }

    fun name(): String {
        return parse(fetch("name.name"))
    }

    fun nameWithMiddle(): String {
        return parse(fetch("name.name_with_middle"))
    }

    fun jobTitles(): List<String> {
        return getMap("name", "title")["job"] as List<String>
    }
}