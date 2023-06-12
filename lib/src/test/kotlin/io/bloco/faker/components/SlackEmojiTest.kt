package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class SlackEmojiTest {
    private val faker = Faker()

    @Test
    fun people() {
        assertNotNull(faker.slackEmoji.people())
    }

    @Test
    fun nature() {
        assertNotNull(faker.slackEmoji.nature())
    }

    @Test
    fun foodAndDrink() {
        assertNotNull(faker.slackEmoji.foodAndDrink())
    }

    @Test
    fun celebration() {
        assertNotNull(faker.slackEmoji.celebration())
    }

    @Test
    fun activity() {
        assertNotNull(faker.slackEmoji.activity())
    }

    @Test
    fun travelAndPlaces() {
        assertNotNull(faker.slackEmoji.travelAndPlaces())
    }

    @Test
    fun objectsAndSymbols() {
        assertNotNull(faker.slackEmoji.objectsAndSymbols())
    }

    @Test
    fun custom() {
        assertNotNull(faker.slackEmoji.custom())
    }

    @Test
    fun emoji() {
        assertNotNull(faker.slackEmoji.emoji())
    }
}
