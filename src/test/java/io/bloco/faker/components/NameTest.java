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
    public void title() throws Exception {
        assertNotNull(faker.name.title());
    }

    @Test
    public void name() throws Exception {
        assertNotNull(faker.name.name());
    }

    @Test
    public void nameWithMiddle() throws Exception {
        assertNotNull(faker.name.nameWithMiddle());
    }

    @Test
    public void jobTitles() throws Exception {
        assertThat(faker.name.jobTitles(), hasItem("Engineer"));
    }
}
