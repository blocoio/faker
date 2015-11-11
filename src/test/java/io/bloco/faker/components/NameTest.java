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
    public void testFirstName() throws Exception {
        assertNotNull(faker.name.firstName());
    }

    @Test
    public void testLastName() throws Exception {
        assertNotNull(faker.name.lastName());
    }

    @Test
    public void testPrefix() throws Exception {
        assertNotNull(faker.name.prefix());
    }

    @Test
    public void testSuffix() throws Exception {
        assertNotNull(faker.name.suffix());
    }

    @Test
    public void testTitleDescription() throws Exception {
        assertNotNull(faker.name.title.descriptor());
    }

    @Test
    public void testTitleLevel() throws Exception {
        assertNotNull(faker.name.title.level());
    }

    @Test
    public void testTitleJob() throws Exception {
        assertNotNull(faker.name.title.job());
    }

    @Test
    public void testName() throws Exception {
        assertNotNull(faker.name.name());
    }
}
