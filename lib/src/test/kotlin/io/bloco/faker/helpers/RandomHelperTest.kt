package io.bloco.faker.helpers

import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import java.security.SecureRandom

class RandomHelperTest {
    private lateinit var randomHelper: RandomHelper
    private lateinit var random: SecureRandom

    @Before
    fun setUp() {
        randomHelper = RandomHelper()
        random = SecureRandom()
    }

    @Test
    fun testNumber() {
        assertTrue(randomHelper.number(0L) == 0L)
        assertTrue(randomHelper.number(random.nextLong() + 1) != 0L)
    }
}
