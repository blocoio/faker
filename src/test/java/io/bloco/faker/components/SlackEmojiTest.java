package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class SlackEmojiTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void people() throws Exception {
        assertNotNull(faker.slackEmoji.people());
    }

    @Test
    public void nature() throws Exception {
        assertNotNull(faker.slackEmoji.nature());
    }

    @Test
    public void foodAndDrink() throws Exception {
        assertNotNull(faker.slackEmoji.foodAndDrink());
    }

    @Test
    public void celebration() throws Exception {
        assertNotNull(faker.slackEmoji.celebration());
    }

    @Test
    public void activity() throws Exception {
        assertNotNull(faker.slackEmoji.activity());
    }

    @Test
    public void travelAndPlaces() throws Exception {
        assertNotNull(faker.slackEmoji.travelAndPlaces());
    }

    @Test
    public void objectsAndSymbols() throws Exception {
        assertNotNull(faker.slackEmoji.objectsAndSymbols());
    }

    @Test
    public void custom() throws Exception {
        assertNotNull(faker.slackEmoji.custom());
    }

    @Test
    public void emoji() throws Exception {
        assertNotNull(faker.slackEmoji.emoji());
    }
}
