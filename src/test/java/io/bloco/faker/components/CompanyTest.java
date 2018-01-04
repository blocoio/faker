package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static io.bloco.faker.test_helpers.RegularExpressionMatcher.matchesPattern;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CompanyTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void name() {
        assertNotNull(faker.company.name());
    }

    @Test
    public void suffix() {
        assertNotNull(faker.company.suffix());
    }

    @Test
    public void industry() {
        assertNotNull(faker.company.industry());
    }

    @Test
    public void catchPhrase() {
        // Should have three or more words
        assertThat(faker.company.catchPhrase(), matchesPattern("^\\S+(\\s\\S+){2,}$"));
    }

    @Test
    public void buzzwords() {
        assertNotNull(faker.company.buzzwords());
    }

    @Test
    public void bs() {
        assertNotNull(faker.company.bs());
    }

    @Test
    public void logo() {
        assertThat(faker.company.logo(),
                matchesPattern(
                        "^https://pigment.github.io/fake-logos/logos/medium/color/\\d{1,2}.png$"));
    }

    @Test
    public void profession() {
        assertNotNull(faker.company.profession());
    }

}
