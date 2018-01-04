package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class AppTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void name() {
        assertNotNull(faker.app.name());
    }

    @Test
    public void version() {
        assertNotNull(faker.app.version());
    }

    @Test
    public void author() {
        assertNotNull(faker.app.author());
    }
}
