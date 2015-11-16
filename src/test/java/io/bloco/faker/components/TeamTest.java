package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class TeamTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void name() throws Exception {
        assertNotNull(faker.team.name());
    }

    @Test
    public void creature() throws Exception {
        assertNotNull(faker.team.creature());
    }

    @Test
    public void state() throws Exception {
        assertNotNull(faker.team.state());
    }

    @Test
    public void sport() throws Exception {
        assertNotNull(faker.team.sport());
    }
}
