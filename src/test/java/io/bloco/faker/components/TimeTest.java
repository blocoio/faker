package io.bloco.faker.components;

import io.bloco.faker.Faker;
import io.bloco.faker.helpers.Period;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class TimeTest {

  private Faker faker;

  @Before public void setUp() throws Exception {
    faker = new Faker();
  }

  @Test public void between() throws Exception {
    DateTime from = new DateTime("1990-06-22");
    DateTime to = new DateTime("1990-06-23");
    DateTime between = new DateTime(faker.time.between(from.toDate(), to.toDate()));

    assertThat(between.isAfter(from), is(true));
    assertThat(between.isBefore(to), is(true));
  }

  @Test public void forward() throws Exception {
    DateTime now = DateTime.now();
    DateTime tenDaysLater = new DateTime(faker.time.forward(10));
    assertThat(tenDaysLater.getDayOfMonth(), is(now.plusDays(10).getDayOfMonth()));
  }

  @Test public void backward() throws Exception {
    DateTime now = DateTime.now();
    DateTime tenDaysBefore = new DateTime(faker.time.backward(10));
    assertThat(tenDaysBefore.getDayOfMonth(), is(now.minusDays(10).getDayOfMonth()));
  }

  @Test public void allPeriod() throws Exception {
    DateTime allPeriod = new DateTime(faker.time.forward(1, Period.all));
    assertThat(allPeriod.getHourOfDay(),
        is(both(greaterThanOrEqualTo(0)).and(lessThanOrEqualTo(23))));
  }

  @Test public void dayPeriod() throws Exception {
    DateTime dayPeriod = new DateTime(faker.time.forward(1, Period.day));
    assertThat(dayPeriod.getHourOfDay(),
        is(both(greaterThanOrEqualTo(9)).and(lessThanOrEqualTo(17))));
  }

  @Test public void nightPeriod() throws Exception {
    DateTime nightPeriod = new DateTime(faker.time.forward(1, Period.night));
    assertThat(nightPeriod.getHourOfDay(),
        is(both(greaterThanOrEqualTo(18)).and(lessThanOrEqualTo(23))));
  }

  @Test public void morningPeriod() throws Exception {
    DateTime morningPeriod = new DateTime(faker.time.forward(1, Period.morning));
    assertThat(morningPeriod.getHourOfDay(),
        is(both(greaterThanOrEqualTo(6)).and(lessThanOrEqualTo(11))));
  }

  @Test public void afternoonPeriod() throws Exception {
    DateTime afternoonPeriod = new DateTime(faker.time.forward(1, Period.afternoon));
    assertThat(afternoonPeriod.getHourOfDay(),
        is(both(greaterThanOrEqualTo(12)).and(lessThanOrEqualTo(17))));
  }

  @Test public void eveningPeriod() throws Exception {
    DateTime eveningPeriod = new DateTime(faker.time.forward(1, Period.evening));
    assertThat(eveningPeriod.getHourOfDay(),
        is(both(greaterThanOrEqualTo(17)).and(lessThanOrEqualTo(21))));
  }

  @Test public void midnightPeriod() throws Exception {
    DateTime midnightPeriod = new DateTime(faker.time.forward(1, Period.midnight));
    assertThat(midnightPeriod.getHourOfDay(),
        is(both(greaterThanOrEqualTo(0)).and(lessThanOrEqualTo(4))));
  }
}
