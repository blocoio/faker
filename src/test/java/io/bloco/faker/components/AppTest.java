package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class AppTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void name() throws Exception {
        assertNotNull(faker.app.name());
    }

    @Test
    public void version() throws Exception {
        assertNotNull(faker.app.version());
    }

    @Test
    public void author() throws Exception {
        assertNotNull(faker.app.author());
    }
}
