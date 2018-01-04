package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class BookTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void title() {
        assertNotNull(faker.book.title());
    }

    @Test
    public void author() {
        assertNotNull(faker.book.author());
    }

    @Test
    public void publisher() {
        assertNotNull(faker.book.publisher());
    }

    @Test
    public void genre() {
        assertNotNull(faker.book.genre());
    }
}
