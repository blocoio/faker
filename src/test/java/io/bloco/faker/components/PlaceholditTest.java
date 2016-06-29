package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class PlaceholditTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void imageDefault() throws Exception {
        String defaultUrl = faker.placeholdit.image();
        assertThat(defaultUrl, containsString("placehold.it"));
        assertThat(defaultUrl, containsString("300x300"));
        assertThat(defaultUrl, containsString("png"));
        assertThat(defaultUrl, not(containsString("text")));
    }

    @Test
    public void imageParams() throws Exception {
        String specificUrl = faker.placeholdit.image("80x80", "gif", "F0F", "0F0", "blah");
        assertThat(specificUrl, containsString("placehold.it"));
        assertThat(specificUrl, containsString("80x80"));
        assertThat(specificUrl, containsString("gif"));
        assertThat(specificUrl, containsString("F0F"));
        assertThat(specificUrl, containsString("0F0"));
        assertThat(specificUrl, containsString("blah"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void imageInvalidSize() {
        faker.placeholdit.image("123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void imageInvalidFormat() {
        faker.placeholdit.image("80x80", "pdf");
    }

    @Test(expected = IllegalArgumentException.class)
    public void imageInvalidBackgroundColor() {
        faker.placeholdit.image("80x80", "gif", "###");
    }

    @Test(expected = IllegalArgumentException.class)
    public void imageTextColorWithoutBackgroundColor() {
        faker.placeholdit.image("80x80", "gif", null, "000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void imageInvalidTextColor() {
        faker.placeholdit.image("80x80", "gif", "999", "###");
    }
}
