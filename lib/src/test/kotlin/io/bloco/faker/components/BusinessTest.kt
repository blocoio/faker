package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.time.LocalDate

class BusinessTest {
    private val faker = Faker()

    @Test
    fun creditCardNumber() {
        assertNotNull(faker.business.creditCardNumber())
    }

    @Test
    fun creditCardExpireDate() {
        val date = faker.business.creditCardExpireDate()
        assertTrue(date.isAfter(LocalDate.now()))
    }

    @Test
    fun creditCardType() {
        assertNotNull(faker.business.creditCardType())
    }
}