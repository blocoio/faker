package io.bloco.faker.helpers;

public class MathHelper {

    public MathHelper() {
    }

    public double round(double number, int precision) {
        double precisionPow = Math.pow(10, precision);
        return Math.round(number * precisionPow) / precisionPow;
    }
}
