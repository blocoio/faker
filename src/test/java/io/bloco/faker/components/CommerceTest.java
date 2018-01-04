package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import io.bloco.faker.Faker;

import static io.bloco.faker.test_helpers.RegularExpressionMatcher.matchesPattern;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.hamcrest.number.OrderingComparison.lessThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class CommerceTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void color() {
        assertNotNull(faker.commerce.color());
    }

    @Test
    public void department() {
        assertNotNull(faker.commerce.department());
        assertThat(faker.commerce.department(1, true), matchesPattern("\\w+"));
        assertThat(faker.commerce.department(1, false), matchesPattern("\\w+"));
        assertThat(faker.commerce.department(2, true), matchesPattern("\\w+ & \\w+"));
        assertThat(faker.commerce.department(3, true), matchesPattern("\\w+, \\w+ & \\w+"));
    }

    @Test
    public void productName() {
        assertNotNull(faker.commerce.productName());
    }

    @Test
    public void material() {
        assertNotNull(faker.commerce.material());
    }

    @Test
    public void price() {
        assertThat(faker.commerce.price(), allOf(
                greaterThanOrEqualTo(new BigDecimal(0)), lessThanOrEqualTo(new BigDecimal(100))));
        assertThat(faker.commerce.price(0, 1), allOf(
                greaterThanOrEqualTo(new BigDecimal(0)), lessThanOrEqualTo(new BigDecimal(1))));
    }

    @Test
    public void promotionCode() {
        assertNotNull(faker.commerce.promotionCode());
        assertThat(faker.commerce.promotionCode(5), matchesPattern("\\w+\\d{5}"));
    }
}
