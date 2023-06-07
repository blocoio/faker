package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class CommerceTest {
    private val faker = Faker()

    @Test
    fun color() {
        assertNotNull(faker.commerce.color())
    }

    @Test
    fun department() {
        assertNotNull(faker.commerce.department())
        assertTrue(faker.commerce.department(1, true).matches(Regex("\\w+")))
        assertTrue(faker.commerce.department(1, false).matches(Regex("\\w+")))
        assertTrue(faker.commerce.department(2, true).matches(Regex("\\w+ & \\w+")))
        assertTrue(faker.commerce.department(3, true).matches(Regex("\\w+, \\w+ & \\w+")))
    }

    @Test
    fun productName() {
        assertNotNull(faker.commerce.productName())
    }

    @Test
    fun material() {
        assertNotNull(faker.commerce.material())
    }

    @Test
    fun price() {
        assertTrue(faker.commerce.price() in BigDecimal(0) .. BigDecimal(100))
        assertTrue(faker.commerce.price(0, 1) in BigDecimal(0) .. BigDecimal(1))
    }

    @Test
    fun promotionCode() {
        assertNotNull(faker.commerce.promotionCode())
        assertTrue(faker.commerce.promotionCode(5).matches(Regex("\\w+\\d{5}")))
    }
}