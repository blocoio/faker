package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class NameTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void firstName() {
        assertNotNull(faker.name.firstName());
    }

    @Test
    public void lastName() {
        assertNotNull(faker.name.lastName());
    }

    @Test
    public void prefix() {
        assertNotNull(faker.name.prefix());
    }

    @Test
    public void suffix() {
        assertNotNull(faker.name.suffix());
    }

    @Test
    public void title() {
        assertNotNull(faker.name.title());
    }

    @Test
    public void name() {
        assertNotNull(faker.name.name());
    }

    @Test
    public void nameWithMiddle() {
        assertNotNull(faker.name.nameWithMiddle());
    }

    @Test
    public void jobTitles() {
        assertThat(faker.name.jobTitles(), hasItem("Engineer"));
    }
}
