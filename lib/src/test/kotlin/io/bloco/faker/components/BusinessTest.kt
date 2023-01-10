package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class BusinessTest {
    private lateinit var faker: Faker
    @Before
    fun setUp() {
        faker = Faker()
    }

    @Test
    fun creditCardNumber() {
        assertNotNull(faker.business.creditCardNumber())
    }

    @Test
    fun creditCardExpireDate() {
        val date = faker.business.creditCardExpireDate()
        val today = LocalDate.now()
        assertTrue(date.isAfter(today))
    }

    @Test
    fun creditCardType() {
        assertNotNull(faker.business.creditCardType())
    }
}