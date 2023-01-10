package io.bloco.faker.helpers

import org.hamcrest.core.Is
import org.hamcrest.core.IsNot
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.security.SecureRandom

class RandomHelperTest {
    private var randomHelper: RandomHelper? = null
    private var random: SecureRandom? = null
    @Before
    fun setUp() {
        randomHelper = RandomHelper()
        random = SecureRandom()
    }

    @Test
    fun testNumber() {
        Assert.assertThat(randomHelper!!.number(0L), Is.`is`(0L))
        Assert.assertThat(randomHelper!!.number(random!!.nextLong() + 1), IsNot.not(0L))
    }
}