package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class SlackEmojiTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void people() {
        assertNotNull(faker.slackEmoji.people());
    }

    @Test
    public void nature() {
        assertNotNull(faker.slackEmoji.nature());
    }

    @Test
    public void foodAndDrink() {
        assertNotNull(faker.slackEmoji.foodAndDrink());
    }

    @Test
    public void celebration() {
        assertNotNull(faker.slackEmoji.celebration());
    }

    @Test
    public void activity() {
        assertNotNull(faker.slackEmoji.activity());
    }

    @Test
    public void travelAndPlaces() {
        assertNotNull(faker.slackEmoji.travelAndPlaces());
    }

    @Test
    public void objectsAndSymbols() {
        assertNotNull(faker.slackEmoji.objectsAndSymbols());
    }

    @Test
    public void custom() {
        assertNotNull(faker.slackEmoji.custom());
    }

    @Test
    public void emoji() {
        assertNotNull(faker.slackEmoji.emoji());
    }
}
