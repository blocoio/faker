package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static io.bloco.faker.test_helpers.RegularExpressionMatcher.matchesPattern;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumberTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void number() throws Exception {
        assertThat(faker.number.number(1), matchesPattern("\\d"));
        assertThat(faker.number.number(5), matchesPattern("[1-9]\\d{4}"));
    }

    @Test
    public void leadingZeroNumber() throws Exception {
        assertThat(faker.number.leadingZeroNumber(1), matchesPattern("\\d"));
        assertThat(faker.number.leadingZeroNumber(5), matchesPattern("\\d{5}"));
    }

    @Test
    public void decimalPart() throws Exception {
        assertThat(faker.number.decimalPart(1), matchesPattern("\\d"));
        assertThat(faker.number.decimalPart(5), matchesPattern("\\d{4}[1-9]"));
    }

    @Test
    public void decimal() throws Exception {
        assertThat(faker.number.decimal(4), matchesPattern("[1-9]\\d{3}\\.\\d[1-9]"));
        assertThat(faker.number.decimal(1, 4), matchesPattern("\\d\\.\\d{3}[1-9]"));
    }

    @Test
    public void digit() throws Exception {
        assertThat(faker.number.digit(), matchesPattern("\\d"));
    }

    @Test
    public void nonZeroDigit() throws Exception {
        assertThat(faker.number.nonZeroDigit(), matchesPattern("[1-9]"));
    }

    @Test
    public void hexadecimal() throws Exception {
        assertThat(faker.number.hexadecimal(1), matchesPattern("[0-9a-f]"));
        assertThat(faker.number.hexadecimal(10), matchesPattern("[0-9a-f]{10}"));
    }

    @Test
    public void betweenDefault() throws Exception {
        assertNotNull(faker.number.between());
    }

    @Test
    public void betweenInt() throws Exception {
        assertThat(faker.number.between(1, 2), anyOf(equalTo(1), equalTo(2)));
        assertThat(faker.number.between(1, 10),
                is(both(greaterThanOrEqualTo(1)).and(lessThanOrEqualTo(10))));
    }

    @Test
    public void betweenDouble() throws Exception {
        assertThat(faker.number.between(1.0, 2.0),
                is(both(greaterThanOrEqualTo(1.0)).and(lessThanOrEqualTo(2.0))));
        assertThat(faker.number.between(-1000, 1000),
                is(both(greaterThanOrEqualTo(-1000)).and(lessThanOrEqualTo(1000))));
    }

    @Test
    public void positiveDefault() throws Exception {
        assertNotNull(faker.number.positive());
    }

    @Test
    public void positive() throws Exception {
        assertThat(faker.number.positive(1, 2), anyOf(equalTo(1), equalTo(2)));
        assertThat(faker.number.positive(-1000.0, 1000.0),
                is(both(greaterThanOrEqualTo(0.0)).and(lessThanOrEqualTo(1000.0))));
    }

    @Test
    public void negativeDefault() throws Exception {
        assertNotNull(faker.number.negative());
    }

    @Test
    public void negative() throws Exception {
        assertThat(faker.number.negative(-2, -1), anyOf(equalTo(-2), equalTo(-1)));
        assertThat(faker.number.negative(-1000.0, 1000.0),
                is(both(greaterThanOrEqualTo(-1000.0)).and(lessThanOrEqualTo(0.0))));
    }
}
