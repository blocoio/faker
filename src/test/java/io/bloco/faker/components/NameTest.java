package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class NameTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void firstName() throws Exception {
        assertNotNull(faker.name.firstName());
    }

    @Test
    public void lastName() throws Exception {
        assertNotNull(faker.name.lastName());
    }

    @Test
    public void prefix() throws Exception {
        assertNotNull(faker.name.prefix());
    }

    @Test
    public void suffix() throws Exception {
        assertNotNull(faker.name.suffix());
    }

    @Test
    public void titleDescription() throws Exception {
        assertNotNull(faker.name.title.descriptor());
    }

    @Test
    public void titleLevel() throws Exception {
        assertNotNull(faker.name.title.level());
    }

    @Test
    public void titleJob() throws Exception {
        assertNotNull(faker.name.title.job());
    }

    @Test
    public void name() throws Exception {
        assertNotNull(faker.name.name());
    }
}
