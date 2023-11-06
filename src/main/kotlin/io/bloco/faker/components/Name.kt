package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Name(data: FakerData) : FakerComponent(data) {

    fun firstName(): String = fetch("name.first_name")

    fun lastName(): String = fetch("name.last_name")

    private fun maleFirstName(): String = fetch("name.male_first_name")
    private fun femaleFirstName(): String = fetch("name.female_first_name")
    private fun maleMiddleName(): String = fetch("name.male_middle_name")
    private fun femaleMiddleName(): String = fetch("name.female_middle_name")
    private fun maleLastName(): String = fetch("name.male_last_name")
    private fun femaleLastName(): String = fetch("name.female_last_name")

    fun prefix(): String = fetch("name.prefix")

    fun suffix(): String = fetch("name.suffix")

    fun title(): String =
        fetch("name.title.descriptor") +
            " " + fetch("name.title.level") +
            " " + fetch("name.title.job")

    fun name(): String = parse(fetch("name.name"))

    fun nameWithMiddle(): String = parse(fetch("name.name_with_middle"))

    @Suppress("UNCHECKED_CAST")
    fun jobTitles(): List<String> = getMap("name", "title")["job"] as List<String>
}
