package io.bloco.faker

import io.bloco.faker.components.Address
import io.bloco.faker.components.App
import io.bloco.faker.components.Artist
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
import io.bloco.faker.helpers.deepMerge
import org.yaml.snakeyaml.Yaml
import java.io.IOException
import java.io.InputStream

class Faker(val locale: String = DEFAULT_LOCALE) {
    @JvmField
    val address: Address

    @JvmField
    val app: App

    @JvmField
    val artist: Artist

    @JvmField
    val avatar: Avatar

    @JvmField
    val book: Book

    @JvmField
    val bool: Bool

    @JvmField
    val business: Business

    @JvmField
    val color: Color

    @JvmField
    val commerce: Commerce

    @JvmField
    val company: Company

    @JvmField
    val date: Date

    @JvmField
    val food: Food

    @JvmField
    val internet: Internet

    @JvmField
    val lorem: Lorem

    @JvmField
    val name: Name

    @JvmField
    val number: Number

    @JvmField
    val placeholdit: Placeholdit

    @JvmField
    val phoneNumber: PhoneNumber

    @JvmField
    val slackEmoji: SlackEmoji

    @JvmField
    val team: Team

    @JvmField
    val time: Time

    @JvmField
    val university: University
    private val data: FakerData

    init {

        // Load data
        val rawData = loadData(DEFAULT_LOCALE) // Fallbacks first
        if (locale != DEFAULT_LOCALE) {
            (rawData as MutableMap<String, Any>).deepMerge(loadData(locale))
        }
        this.data = FakerData(rawData)

        // Load components
        address = data.getComponent(Address::class)
        app = data.getComponent(App::class)
        artist = data.getComponent(Artist::class)
        avatar = data.getComponent(Avatar::class)
        book = data.getComponent(Book::class)
        bool = data.getComponent(Bool::class)
        business = data.getComponent(Business::class)
        color = data.getComponent(Color::class)
        commerce = data.getComponent(Commerce::class)
        company = data.getComponent(Company::class)
        date = data.getComponent(Date::class)
        food = data.getComponent(Food::class)
        internet = data.getComponent(Internet::class)
        lorem = data.getComponent(Lorem::class)
        name = data.getComponent(Name::class)
        number = data.getComponent(Number::class)
        placeholdit = data.getComponent(Placeholdit::class)
        phoneNumber = data.getComponent(PhoneNumber::class)
        slackEmoji = data.getComponent(SlackEmoji::class)
        team = data.getComponent(Team::class)
        time = data.getComponent(Time::class)
        university = data.getComponent(University::class)
    }

    @Suppress("UNCHECKED_CAST")
    private fun loadData(locale: String): Map<String, Any> {
        val yaml = Yaml()
        val input = getDataInputStream(locale)
        val root = yaml.load(input) as Map<String, Any>
        val fakerData = root.values.iterator().next() as Map<String, Any>
        return fakerData["faker"] as Map<String, Any>
    }

    private fun getDataInputStream(locale: String): InputStream {
        val input = javaClass.classLoader
            .getResourceAsStream("locales/$locale.yml")
        try {
            if (input != null && input.available() != 0) {
                return input
            }
        } catch (e: IOException) {
            throw IllegalArgumentException("Unavailable locale '$locale'", e)
        }
        throw IllegalArgumentException("Unavailable locale '$locale'")
    }

    companion object {
        const val DEFAULT_LOCALE = "en"
    }
}
