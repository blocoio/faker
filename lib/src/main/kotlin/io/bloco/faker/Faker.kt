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
import io.bloco.faker.helpers.MapHelper

import org.yaml.snakeyaml.Yaml
import java.io.IOException
import java.io.InputStream

class Faker constructor(val locale: String = DEFAULT_LOCALE) {
    val address: Address
    val app: App
    val avatar: Avatar
    val book: Book
    val bool: Bool
    val business: Business
    val color: Color
    val commerce: Commerce
    val company: Company
    val date: Date
    val food: Food
    val internet: Internet
    val lorem: Lorem
    val name: Name
    val number: Number
    val placeholdit: Placeholdit
    val phoneNumber: PhoneNumber
    val slackEmoji: SlackEmoji
    val team: Team
    val time: Time
    val university: University
    private val data: FakerData

    init {

        // Load data
        val data = loadData(DEFAULT_LOCALE) // Fallbacks first
        if (locale != DEFAULT_LOCALE) {
            MapHelper.deepMerge(data as MutableMap<String, Any>, loadData(locale))
        }
        this.data = FakerData(data)

        // Load components
        address = this.data.getComponent(Address::class.java)
        app = this.data.getComponent(App::class.java)
        avatar = this.data.getComponent(Avatar::class.java)
        book = this.data.getComponent(Book::class.java)
        bool = this.data.getComponent(Bool::class.java)
        business = this.data.getComponent(Business::class.java)
        color = this.data.getComponent(Color::class.java)
        commerce = this.data.getComponent(Commerce::class.java)
        company = this.data.getComponent(Company::class.java)
        date = this.data.getComponent(Date::class.java)
        food = this.data.getComponent(Food::class.java)
        internet = this.data.getComponent(Internet::class.java)
        lorem = this.data.getComponent(Lorem::class.java)
        name = this.data.getComponent(Name::class.java)
        number = this.data.getComponent(Number::class.java)
        placeholdit = this.data.getComponent(Placeholdit::class.java)
        phoneNumber = this.data.getComponent(PhoneNumber::class.java)
        slackEmoji = this.data.getComponent(SlackEmoji::class.java)
        team = this.data.getComponent(Team::class.java)
        time = this.data.getComponent(Time::class.java)
        university = this.data.getComponent(University::class.java)
    }

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
            //TODO
        }
        throw IllegalArgumentException("Unavailable locale \'$locale\'")
    }

    companion object {
        const val DEFAULT_LOCALE = "en"
    }
}
