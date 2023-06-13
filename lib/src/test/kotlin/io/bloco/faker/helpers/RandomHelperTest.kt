package io.bloco.faker.helpers

import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.security.SecureRandom

class RandomHelperTest {

    @Test
    fun testNumber() {
        assertTrue(RandomHelper.number(0L) == 0L)
        assertTrue(RandomHelper.number(SecureRandom().nextLong() + 1) != 0L)
    }
}
