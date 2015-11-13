package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class AvatarTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void imageDefault() throws Exception {
        String defaultUrl = faker.avatar.image();
        assertThat(defaultUrl, containsString("robohash.org"));
        assertThat(defaultUrl, containsString("image"));
        assertThat(defaultUrl, containsString("300x300"));
        assertThat(defaultUrl, containsString("png"));
        assertThat(defaultUrl, containsString("set1"));
        assertThat(defaultUrl, not(containsString("bgset")));
    }

    @Test
    public void imageParams() throws Exception {
        String specificUrl = faker.avatar.image("my-slug", "80x80", "bmp", "set2", "bgset1");
        assertThat(specificUrl, containsString("robohash.org"));
        assertThat(specificUrl, containsString("my-slug"));
        assertThat(specificUrl, containsString("80x80"));
        assertThat(specificUrl, containsString("bmp"));
        assertThat(specificUrl, containsString("set2"));
        assertThat(specificUrl, containsString("bgset1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void imageInvalidSize() {
        faker.avatar.image("my-slug", "123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void imageInvalidFormat() {
        faker.avatar.image("my-slug", "80x80", "pdf");
    }
}
