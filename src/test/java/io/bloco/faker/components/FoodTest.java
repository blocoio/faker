package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static io.bloco.faker.test_helpers.RegularExpressionMatcher.matchesPattern;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class FoodTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void dish() {
        assertNotNull(faker.food.dish());
    }

    @Test
    public void description() {
        assertNotNull(faker.food.description());
    }

    @Test
    public void ingredient() {
        assertNotNull(faker.food.ingredient());
    }

    @Test
    public void spice() {
        assertNotNull(faker.food.spice());
    }

    @Test
    public void measurement() {
        assertNotNull(faker.food.measurement());
        assertThat(faker.food.measurement(), matchesPattern("[\\d\\/]+ \\w+"));
    }

    @Test
    public void metricMeasurement() {
        assertNotNull(faker.food.metricMeasurement());
    }
}
