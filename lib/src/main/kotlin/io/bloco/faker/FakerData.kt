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
import io.bloco.faker.components.PhoneNumber
import io.bloco.faker.components.Placeholdit
import io.bloco.faker.components.SlackEmoji
import io.bloco.faker.components.Team
import io.bloco.faker.components.Time
import io.bloco.faker.components.University
import io.bloco.faker.helpers.StringHelper
import kotlin.reflect.KClass

class FakerData(private val data: Map<String, Any>) {
    private val stringHelper: StringHelper = StringHelper()

    private val components: Map<String, FakerComponent> = listOf(
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
    ).associateBy { it.key }

    fun <K : FakerComponent> getComponent(componentClass: KClass<K>): K {
        val componentKey = componentClass.simpleName!!
        return getComponentByKey(componentKey)
    }

    fun <K : FakerComponent> getComponentByKey(componentKey: String): K {
        val componentKeyInSnake: String = stringHelper.camelToSnake(componentKey)
        @Suppress("UNCHECKED_CAST")
        return (components[componentKeyInSnake] as? K)
            ?: throw IllegalArgumentException("Unsupported component '$componentKey'")
    }

    fun getComponentData(componentKey: String): Map<String, Any> {
        @Suppress("UNCHECKED_CAST")
        return get(componentKey) as Map<String, Any>?
            ?: throw IllegalArgumentException("Unsupported component '$componentKey'")
    }

    operator fun get(componentKey: String): Any? {
        return data[componentKey]
    }
}
