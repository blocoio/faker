package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class BookTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void title() throws Exception {
        assertNotNull(faker.book.title());
    }

    @Test
    public void author() throws Exception {
        assertNotNull(faker.book.author());
    }

    @Test
    public void publisher() throws Exception {
        assertNotNull(faker.book.publisher());
    }

    @Test
    public void genre() throws Exception {
        assertNotNull(faker.book.genre());
    }
}
