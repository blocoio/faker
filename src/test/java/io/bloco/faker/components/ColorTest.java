package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static io.bloco.faker.test_helpers.RegularExpressionMatcher.matchesPattern;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ColorTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void hexColor() {
        assertThat(faker.color.hexColor(), matchesPattern("^#[0-9a-f]{6}$"));
    }

    @Test
    public void color() {
        assertNotNull(faker.color.colorName());
    }

    @Test
    public void singleRgbColor() {
        assertSingleRgbColor(faker.color.singleRgbColor());
    }

    @Test
    public void rgbColor() {
        int[] color = faker.color.rgbColor();
        assertThat(color.length, is(equalTo(3)));
        assertSingleRgbColor(color[0]);
        assertSingleRgbColor(color[1]);
        assertSingleRgbColor(color[2]);
    }

    @Test
    public void singleHslColor() {
        assertSingleHslColor(faker.color.singleHslColor());
    }

    @Test
    public void alphaChannel() {
        assertAlphaChannel(faker.color.alphaChannel());
    }

    @Test
    public void hslColor() {
        double[] color = faker.color.hslColor();
        assertThat(color.length, is(equalTo(3)));
        assertSingleHslColor(color[0]);
        assertSingleHslColor(color[1]);
        assertSingleHslColor(color[2]);
    }

    @Test
    public void hslaColor() {
        double[] color = faker.color.hslaColor();
        assertThat(color.length, is(equalTo(4)));
        assertSingleHslColor(color[0]);
        assertSingleHslColor(color[1]);
        assertSingleHslColor(color[2]);
        assertAlphaChannel(color[3]);
    }

    private void assertSingleRgbColor(int singleRgbColor) {
        assertThat(singleRgbColor, allOf(greaterThanOrEqualTo(0), lessThan(Color.MAX_RGB)));
    }

    private void assertSingleHslColor(double singleHslColor) {
        assertThat(singleHslColor, allOf(greaterThanOrEqualTo(0d), lessThan(Color.MAX_HSL)));
    }

    private void assertAlphaChannel(double alpha) {
        assertThat(alpha, allOf(greaterThanOrEqualTo(0d), lessThanOrEqualTo(1d)));
    }
}
