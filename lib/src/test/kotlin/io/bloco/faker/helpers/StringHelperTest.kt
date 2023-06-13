package io.bloco.faker.helpers

import junit.framework.TestCase.assertTrue
import org.junit.Test

class StringHelperTest {

    @Test
    fun testSnakeToCamel() {
        assertTrue("hello".snakeToCamel() == "hello")
        assertTrue("first_name".snakeToCamel() == "firstName")
        assertTrue("once_upon_a_time".snakeToCamel() == "onceUponATime")
    }

    @Test
    fun testCamelToSnake() {
        assertTrue("HelloWorld".camelToSnake() == "hello_world")
        assertTrue("SlackEmoji".camelToSnake() == "slack_emoji")
        assertTrue("RGB".camelToSnake() == "r_g_b")
        assertTrue("Rgb".camelToSnake() == "rgb")
    }

    @Test
    fun testNormalize() {
        assertTrue("Sérgio Santos".normalize() == "sergiosantos")
        assertTrue("áàãâäå".normalize() == "aaaaaa")
        assertTrue("-.@,;!?".normalize() == "")
    }
}
