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
}
