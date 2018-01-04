package io.bloco.faker.helpers;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class MathHelperTest {

    private MathHelper mathHelper;

    @Before
    public void setUp() {
        mathHelper = new MathHelper();
    }

    @Test
    public void testRound() {
        assertThat(mathHelper.round(11.115d, 2), is(closeTo(11.12, 0.001)));
        assertThat(mathHelper.round(11.114d, 2), is(closeTo(11.11, 0.001)));
        assertThat(mathHelper.round(10, 0), is(closeTo(10, 0.00001)));
    }
}
