package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

class FoodTest {
    private val faker = Faker()

    @Test
    fun dish() {
        assertNotNull(faker.food.dish())
    }

    @Test
    fun description() {
        assertNotNull(faker.food.description())
    }

    @Test
    fun ingredient() {
        assertNotNull(faker.food.ingredient())
    }

    @Test
    fun spice() {
        assertNotNull(faker.food.spice())
    }

    @Test
    fun measurement() {
        assertNotNull(faker.food.measurement())
        assertTrue(faker.food.measurement().matches(Regex("[\\d\\/]+ \\w+")))
    }

    @Test
    fun metricMeasurement() {
        assertNotNull(faker.food.metricMeasurement())
    }
}