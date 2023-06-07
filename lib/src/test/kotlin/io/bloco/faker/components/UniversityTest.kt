package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class UniversityTest {
    private val faker = Faker()

    @Test
    fun name() {
        assertNotNull(faker.university.name())
    }

    @Test
    fun prefix() {
        assertNotNull(faker.university.prefix())
    }

    @Test
    fun suffix() {
        assertNotNull(faker.university.suffix())
    }
}