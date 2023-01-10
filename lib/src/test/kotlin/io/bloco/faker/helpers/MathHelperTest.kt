package io.bloco.faker.helpers

import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class MathHelperTest {
    private lateinit var mathHelper: MathHelper

    @Before
    fun setUp() {
        mathHelper = MathHelper()
    }

    @Test
    fun testRound() {
        assertTrue(mathHelper.round(11.115, 2) == 11.12)
        assertTrue(mathHelper.round(11.114, 2) == 11.11)
        assertTrue(mathHelper.round(10.0, 2) == 10.0)
    }
}