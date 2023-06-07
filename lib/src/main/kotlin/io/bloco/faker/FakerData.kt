package io.bloco.faker

import io.bloco.faker.components.Address
import io.bloco.faker.components.App
import io.bloco.faker.components.Avatar
import io.bloco.faker.components.Book
import io.bloco.faker.components.Bool
import io.bloco.faker.components.Business
import io.bloco.faker.components.Color
import io.bloco.faker.components.Commerce
import io.bloco.faker.components.Company
import io.bloco.faker.components.Date
import io.bloco.faker.components.Food
import io.bloco.faker.components.Internet
import io.bloco.faker.components.Lorem
import io.bloco.faker.components.Name
import io.bloco.faker.components.Number
import io.bloco.faker.components.Placeholdit
import io.bloco.faker.components.PhoneNumber
import io.bloco.faker.components.SlackEmoji
import io.bloco.faker.components.Team
import io.bloco.faker.components.Time
import io.bloco.faker.components.University
import io.bloco.faker.helpers.StringHelper

class FakerData(private val data: Map<String, Any>) {
    private val components: MutableMap<String, FakerComponent>
    private val stringHelper: StringHelper

    init {

        // Load components
        val componentsList = arrayOf(
            Address(this),
            App(this),
            Avatar(this),
            Book(this),
            Bool(this),
            Business(this),
            Color(this),
            Commerce(this),
            Company(this),
            Date(this),
            Food(this),
            Internet(this),
            Lorem(this),
            Name(this),
            Number(this),
            Placeholdit(this),
            PhoneNumber(this),
            SlackEmoji(this),
            Team(this),
            Time(this),
            University(this)
        )
        components = HashMap(componentsList.size)
        for (component in componentsList) {
            components[component.key] = component
        }
        stringHelper = StringHelper()
    }

    fun <K : FakerComponent> getComponent(componentClass: Class<K>): K {
        val componentKey = componentClass.simpleName
        return getComponentByKey(componentKey) as K
    }

    fun getComponentByKey(componentKey: String): FakerComponent {
        val componentKeyInSnake: String = stringHelper.camelToSnake(componentKey)
        return components[componentKeyInSnake]
            ?: throw IllegalArgumentException("Unsupported component '$componentKey'")
    }

    fun getComponentData(componentKey: String): Map<String, Any> {
        return get(componentKey) as Map<String, Any>?
            ?: throw IllegalArgumentException("Unsupported component '$componentKey'")
    }

    operator fun get(componentKey: String): Any? {
        return data[componentKey]
    }
}