package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class UniversityTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void name() {
        assertNotNull(faker.university.name());
    }

    @Test
    public void prefix() {
        assertNotNull(faker.university.prefix());
    }

    @Test
    public void suffix() {
        assertNotNull(faker.university.suffix());
    }
}
