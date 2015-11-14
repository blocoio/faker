package io.bloco.faker.components;

import io.bloco.faker.helpers.Period;
import java.util.Date;
import java.util.Random;
import org.joda.time.DateTime;

public class Time {

  private final Random random;

  public Time() {
    this.random = new Random();
  }

  public Date between(Date from, Date to, Period period) {
    return between(new DateTime(from), new DateTime(to), period).toDate();
  }

  public Date between(Date from, Date to) {
    return between(from, to, Period.all);
  }

  public Date forward(int numberOfDays, Period period) {
    return randomTime(now(), period).plusDays(numberOfDays).toDate();
  }

  public Date forward(int numberOfDays) {
    return forward(numberOfDays, Period.all);
  }

  public Date backward(int numberOfDays, Period period) {
    return randomTime(now(), period).minusDays(numberOfDays).toDate();
  }

  public Date backward(int numberOfDays) {
    return backward(numberOfDays, Period.all);
  }

  private DateTime now() {
    return DateTime.now();
  }

  private DateTime between(DateTime from, DateTime to, Period period) {
    return randomTime(new DateTime(getRandomTimeBetweenTwoDates(from, to)), period);
  }

  private long getRandomTimeBetweenTwoDates(DateTime from, DateTime to) {
    long diff = to.getMillis() - from.getMillis() + 1;
    return from.getMillis() + (long) (Math.random() * diff);
  }

  private DateTime randomTime(DateTime dateTime, Period period) {
    return dateTime.withHourOfDay(hours(period))
        .withMinuteOfHour(minutes())
        .withSecondOfMinute(seconds());
  }

  private int hours(Period period) {
    int[] values = period.getValues();
    return values[random.nextInt(values.length)];
  }

  private int minutes() {
    return random.nextInt(60);
  }

  private int seconds() {
    return random.nextInt(60);
  }
}
