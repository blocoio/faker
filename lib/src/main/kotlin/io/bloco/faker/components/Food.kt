package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Food(data: FakerData) : FakerComponent(data) {
    fun dish(): String {
        return fetch("food.dish")
    }

    fun description(): String {
        return fetch("food.descriptions")
    }

    fun ingredient(): String {
        return fetch("food.ingredients")
    }

    fun spice(): String {
        return fetch("food.spices")
    }

    fun measurement(): String {
        return fetch("food.measurement_sizes") + " " + fetch("food.measurements")
    }

    fun metricMeasurement(): String {
        return fetch("food.metric_measurements")
    }
}