package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class TeamTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void name() {
        assertNotNull(faker.team.name());
    }

    @Test
    public void creature() {
        assertNotNull(faker.team.creature());
    }

    @Test
    public void state() {
        assertNotNull(faker.team.state());
    }

    @Test
    public void sport() {
        assertNotNull(faker.team.sport());
    }
}
