package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Number extends FakerComponent {

    private static final int DEFAULT_DECIMAL_PART_DIGITS = 2;
    private static final int DEFAULT_FROM = 1;
    private static final int DEFAULT_TO = 5000;

    public Number(FakerData data) {
        super(data);
    }

    public String number(int digits) {
        String num = "";
        if (digits > 1) {
            num = nonZeroDigit();
            digits -= 1;
        }
        return num + leadingZeroNumber(digits);
    }

    public String leadingZeroNumber(int digits) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits; i++) {
            sb.append(digit());
        }
        return sb.toString();
    }

    public String decimalPart(int digits) {
        String num = "";
        if (digits > 1) {
            num = nonZeroDigit();
            digits -= 1;
        }
        return leadingZeroNumber(digits) + num;
    }

    public String decimal(int leftDigits) {
        return decimal(leftDigits, DEFAULT_DECIMAL_PART_DIGITS);
    }

    public String decimal(int leftDigits, int rightDigits) {
        return number(leftDigits) + "." + decimalPart(rightDigits);
    }

    public String digit() {
        return Integer.toString(randomHelper.number(10));
    }

    public String nonZeroDigit() {
        return Integer.toString(randomHelper.number(9) + 1);
    }

    public String hexadecimal(int digits) {
        if (digits < 1) {
            return "";
        }
        long num = randomHelper.number((long) Math.pow(16, digits));
        return String.format("%0" + digits + "x", num);
    }

    public int between() {
        return between(DEFAULT_FROM, DEFAULT_TO);
    }

    public int between(int from, int to) {
        return randomHelper.range(from, to);
    }

    public long between(long from, long to) {
      return randomHelper.range(from, to);
    }

    public double between(double from, double to) {
        return randomHelper.range(from, to);
    }

    public int positive() {
        return positive(DEFAULT_FROM, DEFAULT_TO);
    }

    public int positive(int from, int to) {
        return Math.abs(between(from, to));
    }

    public long positive(long from, long to) {
        return Math.abs(between(from, to));
    }

    public double positive(double from, double to) {
        return Math.abs(between(from, to));
    }

    public int negative() {
        return negative(DEFAULT_FROM, DEFAULT_TO);
    }

    public int negative(int from, int to) {
        return Math.abs(between(from, to)) * -1;
    }

    public long negative(long from, long to) {
        return Math.abs(between(from, to)) * -1;
    }

    public double negative(double from, double to) {
        return Math.abs(between(from, to)) * -1;
    }
}
