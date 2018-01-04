package io.bloco.faker.components;

import io.bloco.faker.Faker;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class DateTest {

    private Faker faker;
    private DateFormat dateFormat;

    @Before
    public void setUp() {
        faker = new Faker();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Test
    public void between() throws Exception {
        String from = "1990-06-22";
        String to = "1990-06-23";

        java.util.Date fromDate = dateFormat.parse(from);
        java.util.Date toDate = dateFormat.parse(to);

        assertThat(faker.date.between(from, to), anyOf(equalTo(fromDate), equalTo(toDate)));
        assertThat(faker.date.between(fromDate, toDate), anyOf(equalTo(fromDate), equalTo(toDate)));
    }

    @Test
    public void forward() {
        java.util.Date today = new DateTime().withTimeAtStartOfDay().toDate();
        java.util.Date tomorrow = new DateTime().plusDays(1).withTimeAtStartOfDay().toDate();
        java.util.Date in100Days = new DateTime().plusDays(100).withTimeAtStartOfDay().toDate();

        assertThat(faker.date.forward(1),
                anyOf(equalTo(today), equalTo(tomorrow)));
        assertThat(faker.date.forward(100),
                allOf(greaterThanOrEqualTo(today), lessThanOrEqualTo(in100Days)));
    }

    @Test
    public void forwardDefault() {
        assertNotNull(faker.date.forward());
    }

    @Test
    public void backward() {
        java.util.Date today = new DateTime().withTimeAtStartOfDay().toDate();
        java.util.Date yesterday = new DateTime().minusDays(1).withTimeAtStartOfDay().toDate();
        java.util.Date minus100Days = new DateTime().minusDays(100).withTimeAtStartOfDay().toDate();

        assertThat(faker.date.backward(1),
                anyOf(equalTo(today), equalTo(yesterday)));
        assertThat(faker.date.backward(100),
                allOf(greaterThanOrEqualTo(minus100Days), lessThanOrEqualTo(today)));
    }

    @Test
    public void backwardDefault() {
        assertNotNull(faker.date.backward());
    }

    @Test
    public void birthday() {
        java.util.Date nextYear = new DateTime().plusYears(1).withTimeAtStartOfDay().toDate();
        java.util.Date in10Years = new DateTime().plusYears(10).withTimeAtStartOfDay().toDate();

        assertThat(faker.date.birthday(1, 10),
                allOf(greaterThanOrEqualTo(nextYear), lessThanOrEqualTo(in10Years)));
    }

    @Test
    public void birthdayDefault() {
        assertNotNull(faker.date.birthday());
    }
}
