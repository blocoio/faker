package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase
import junit.framework.TestCase.assertNotNull
import org.junit.Test

class CompanyTest {
    private val faker = Faker()

    @Test
    fun name() {
        assertNotNull(faker.company.name())
    }

    @Test
    fun suffix() {
        assertNotNull(faker.company.suffix())
    }

    @Test
    fun industry() {
        assertNotNull(faker.company.industry())
    }

    @Test
    fun catchPhrase() {
        // Should have three or more words
        TestCase.assertTrue(faker.company.catchPhrase().matches(Regex("^\\S+(\\s\\S+){2,}$")))
    }

    @Test
    fun buzzwords() {
        assertNotNull(faker.company.buzzwords())
    }

    @Test
    fun bs() {
        assertNotNull(faker.company.bs())
    }

    @Test
    fun logo() {
        TestCase.assertTrue(
            faker.company.logo()
                .matches(Regex("^https://pigment.github.io/fake-logos/logos/medium/color/\\d{1,2}.png$"))
        )
    }

    @Test
    fun profession() {
        assertNotNull(faker.company.profession())
    }
}