package io.bloco.faker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class FakerTest {
    @Test
    public void testLoadComponents() {
        Faker faker = new Faker();
        assertNotNull(faker.app);
    }

    @Test
    public void testLocaleDefault() {
        Faker faker = new Faker();
        assertThat(faker.getLocale(), is(equalTo(Faker.DEFAULT_LOCALE)));
    }

    @Test
    public void testLocaleProvided() {
        Faker faker = new Faker("nl");
        assertThat(faker.getLocale(), is(equalTo("nl")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLocaleInvalid() {
        new Faker("invalid-locale");
    }

    @Test
    public void testLocaleFallback() {
        // Dutch doesn't have App.name, but English (the default) has
        Faker faker = new Faker("nl");
        assertNotNull(faker.app.name());
        assertNotNull(faker.company.name());
    }
}