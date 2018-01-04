package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Food extends FakerComponent {

    public Food(FakerData data) {
        super(data);
    }

    public String dish() {
        return fetch("food.dish");
    }

    public String description() {
        return fetch("food.descriptions");
    }

    public String ingredient() {
        return fetch("food.ingredients");
    }

    public String spice() {
        return fetch("food.spices");
    }

    public String measurement() {
        return fetch("food.measurement_sizes") + " " + fetch("food.measurements");
    }

    public String metricMeasurement() {
        return fetch("food.metric_measurements");
    }
}
