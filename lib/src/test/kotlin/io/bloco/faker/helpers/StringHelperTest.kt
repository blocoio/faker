package io.bloco.faker.helpers

import junit.framework.TestCase.assertTrue
import org.junit.Test

class StringHelperTest {
    private val stringHelper = StringHelper()

    @Test
    fun testSnakeToCamel() {
        assertTrue(stringHelper.snakeToCamel("hello") == "hello")
        assertTrue(stringHelper.snakeToCamel("first_name") == "firstName")
        assertTrue(stringHelper.snakeToCamel("once_upon_a_time") == "onceUponATime")
    }

    @Test
    fun testCamelToSnake() {
        assertTrue(stringHelper.camelToSnake("HelloWorld") == "hello_world")
        assertTrue(stringHelper.camelToSnake("SlackEmoji") == "slack_emoji")
        assertTrue(stringHelper.camelToSnake("RGB") == "r_g_b")
        assertTrue(stringHelper.camelToSnake("Rgb") == "rgb")
    }

    @Test
    fun testNormalize() {
        assertTrue(stringHelper.normalize("Sérgio Santos") == "sergiosantos")
        assertTrue(stringHelper.normalize("áàãâäå") == "aaaaaa")
        assertTrue(stringHelper.normalize("-.@,;!?") == "")
    }
}