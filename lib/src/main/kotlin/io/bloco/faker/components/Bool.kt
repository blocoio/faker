package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Bool(data: FakerData) : FakerComponent(data) {
    fun bool(trueRatio: Float = 0.5f): Boolean {
        return Math.random() < trueRatio
    }
}