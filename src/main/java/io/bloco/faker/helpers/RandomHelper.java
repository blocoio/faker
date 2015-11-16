package io.bloco.faker.helpers;

import java.util.List;
import java.util.Random;

public class RandomHelper {

    private Random random;

    public RandomHelper() {
        random = new Random();
    }

    public Object sample(List options) {
        return options.get(random.nextInt(options.size()));
    }

    public String digit() {
        return Integer.toString(random.nextInt(10));
    }

    public int number(int max) {
        return random.nextInt(max);
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
