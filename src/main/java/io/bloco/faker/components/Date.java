package io.bloco.faker.components;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Date extends FakerComponent {

    private static final int DEFAULT_NUM_OF_DAYS = 365;
    private static final int DEFAULT_MIN_AGE = 18;
    private static final int DEFAULT_MAX_AGE = 65;

    private final DateFormat dateFormat;

    public Date(FakerData fakerData) {
        super(fakerData);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public java.util.Date between(String from, String to) {
        java.util.Date fromDate, toDate;

        try {
            fromDate = dateFormat.parse(from);
            toDate = dateFormat.parse(to);
        } catch (ParseException exception) {
            throw new RuntimeException(exception);
        }

        return between(fromDate, toDate);
    }

    public java.util.Date between(java.util.Date from, java.util.Date to) {
        return between(new DateTime(from), new DateTime(to));
    }

    public java.util.Date forward() {
        return forward(DEFAULT_NUM_OF_DAYS);
    }

    public java.util.Date forward(int numberOfDays) {
        return between(today(), today().plusDays(numberOfDays));
    }

    public java.util.Date backward() {
        return backward(DEFAULT_NUM_OF_DAYS);
    }

    public java.util.Date backward(int numberOfDays) {
        return between(today().minusDays(numberOfDays), today());
    }

    public java.util.Date birthday() {
        return birthday(DEFAULT_MIN_AGE, DEFAULT_MAX_AGE);
    }

    public java.util.Date birthday(int minAge, int maxAge) {
        return between(today().plusYears(minAge), today().plusYears(maxAge));
    }

    // Helpers

    private java.util.Date between(DateTime from, DateTime to) {
        return getRandomDate(from, to).withTimeAtStartOfDay().toDate();
    }

    private DateTime today() {
        return new DateTime().withTimeAtStartOfDay();
    }

    private DateTime getRandomDate(DateTime from, DateTime to) {
        Duration duration = new Duration(from, to);
        long diffInDays = duration.getStandardDays();
        return from.plusDays((int) randomHelper.number(diffInDays) + 1);
    }
}
