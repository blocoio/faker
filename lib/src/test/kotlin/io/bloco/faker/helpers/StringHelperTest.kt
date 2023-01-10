package io.bloco.faker.helpers

import io.bloco.faker.helpers.StringHelper.StringReplacer
import junit.framework.TestCase.assertTrue
import org.hamcrest.core.Is
import org.hamcrest.core.IsEqual
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*
import java.util.regex.Matcher

class StringHelperTest {
    private lateinit var stringHelper: StringHelper

    @Before
    fun setUp() {
        stringHelper = StringHelper()
    }

    @Test
    fun testReplaceMethod() {
        assertTrue(
            stringHelper.replaceMethod("aaa", ".", object : StringReplacer {
                override fun replaceWith(matcher: Matcher): String {
                    return "b"
                }
            }) == "bbb"
        )

        assertTrue(
            stringHelper.replaceMethod("abc", "a(.)", object : StringReplacer {
                override fun replaceWith(matcher: Matcher): String {
                    return matcher.group(1).uppercase(Locale.getDefault())
                }
            }) == "Bc"
        )
    }

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