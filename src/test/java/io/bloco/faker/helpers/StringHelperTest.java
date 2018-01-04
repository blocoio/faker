package io.bloco.faker.helpers;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class StringHelperTest {

    private StringHelper stringHelper;

    @Before
    public void setUp() {
        stringHelper = new StringHelper();
    }

    @Test
    public void testReplaceMethod() {
        assertThat(stringHelper.replaceMethod("aaa", ".", new StringHelper.StringReplacer() {
            @Override
            public String replaceWith(Matcher matcher) {
                return "b";
            }
        }), is(equalTo("bbb")));

        assertThat(stringHelper.replaceMethod("abc", "a(.)", new StringHelper.StringReplacer() {
            @Override
            public String replaceWith(Matcher matcher) {
                return matcher.group(1).toUpperCase();
            }
        }), is(equalTo("Bc")));
    }

    @Test
    public void testSnakeToCamel() {
        assertThat(stringHelper.snakeToCamel("hello"), is(equalTo("hello")));
        assertThat(stringHelper.snakeToCamel("first_name"), is(equalTo("firstName")));
        assertThat(stringHelper.snakeToCamel("once_upon_a_time"), is(equalTo("onceUponATime")));
    }

    @Test
    public void testCamelToSnake() {
        assertThat(stringHelper.camelToSnake("HelloWorld"), is(equalTo("hello_world")));
        assertThat(stringHelper.camelToSnake("SlackEmoji"), is(equalTo("slack_emoji")));
        assertThat(stringHelper.camelToSnake("RGB"), is(equalTo("r_g_b")));
        assertThat(stringHelper.camelToSnake("Rgb"), is(equalTo("rgb")));
    }

    @Test
    public void testNormalize() {
        assertThat(stringHelper.normalize("Sérgio Santos"), is(equalTo("sergiosantos")));
        assertThat(stringHelper.normalize("áàãâäå"), is(equalTo("aaaaaa")));
        assertThat(stringHelper.normalize("-.@,;!?"), is(equalTo("")));
    }
}
