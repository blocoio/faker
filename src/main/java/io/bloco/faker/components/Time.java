package io.bloco.faker.components;

import org.joda.time.DateTime;

import java.util.Date;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;
import io.bloco.faker.helpers.Period;

public class Time extends FakerComponent {

    public Time(FakerData fakerData) {
        super(fakerData);
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
        return values[randomHelper.number(values.length)];
    }

    private int minutes() {
        return randomHelper.number(60);
    }

    private int seconds() {
        return randomHelper.number(60);
    }
}
