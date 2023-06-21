package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase
import org.junit.Test

class ArtistTest {
    private val faker = Faker()

    @Test
    fun name() {
        TestCase.assertNotNull(faker.artist.name())
    }
}
