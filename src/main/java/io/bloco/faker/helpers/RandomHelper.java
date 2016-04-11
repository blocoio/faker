package io.bloco.faker.helpers;

import java.util.List;
import java.util.Random;

public class RandomHelper {

    private Random random;

    public RandomHelper() {
        random = new Random();
    }

    public <T> T sample(List<T> options) {
        return options.get(random.nextInt(options.size()));
    }

    public String digit() {
        return Integer.toString(random.nextInt(10));
    }

    public boolean randBoolean() {
        return random.nextBoolean();
    }

    public int number(int max) {
        return random.nextInt(max);
    }

    public long number(long max) {
        return Math.abs(random.nextLong()) % max;
    }

    public int numberByLength(int length) {
        return random.nextInt((int) Math.pow(10, length));
    }

    public int range(int min, int max) {
        if (min == max) {
            return min;
        }
        if (max < min) {
            int temp = max;
            max = min;
            min = temp;
        }
        return number(max - min + 1) + min;
    }

    public long range(long min, long max) {
        if (min == max) {
            return min;
        }
        if (max < min) {
            long temp = max;
            max = min;
            min = temp;
        }
        return number(max - min + 1) + min;
    }

    public double range(double min, double max) {
        if (max < min) {
            double temp = max;
            max = min;
            min = temp;
        }
        return random.nextDouble() * (max - min) + min;
    }

    public double randDouble() {
        return random.nextDouble();
    }
}
