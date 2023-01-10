package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import org.junit.Before
import org.junit.Test

class TeamTest {
    private lateinit var faker: Faker
    @Before
    fun setUp() {
        faker = Faker()
    }

    @Test
    fun name() {
        assertNotNull(faker.team.name())
    }

    @Test
    fun creature() {
        assertNotNull(faker.team.creature())
    }

    @Test
    fun state() {
        assertNotNull(faker.team.state())
    }

    @Test
    fun sport() {
        assertNotNull(faker.team.sport())
    }
}