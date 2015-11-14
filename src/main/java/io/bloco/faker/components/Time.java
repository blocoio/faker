package io.bloco.faker.components;

import io.bloco.faker.helpers.Period;
import java.util.Random;
import org.joda.time.DateTime;

public class Time {

  private final Random random;

  public Time() {
    this.random = new Random();
  }

  public DateTime between(DateTime from, DateTime to, Period period) {
    return randomTime(new DateTime(getRandomTimeBetweenTwoDates(from, to)), period);
  }

  public DateTime between(DateTime from, DateTime to) {
    return randomTime(new DateTime(getRandomTimeBetweenTwoDates(from, to)), Period.all);
  }

  public DateTime forward(int numberOfDays, Period period) {
    return randomTime(now(), period).plusDays(numberOfDays);
  }

  public DateTime forward(int numberOfDays) {
    return randomTime(now(), Period.all).plusDays(numberOfDays);
  }

  public DateTime backward(int numberOfDays, Period period) {
    return randomTime(now(), period).minusDays(numberOfDays);
  }

  public DateTime backward(int numberOfDays) {
    return randomTime(now(), Period.all).minusDays(numberOfDays);
  }

  private DateTime now() {
    return DateTime.now();
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
