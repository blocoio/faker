package io.bloco.faker.helpers;

import org.junit.Before;
import org.junit.Test;

import java.security.SecureRandom;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class RandomHelperTest {

    private RandomHelper randomHelper;
    private SecureRandom random;

    @Before
    public void setUp() {
        randomHelper = new RandomHelper();
        random = new SecureRandom();
    }

    @Test
    public void testNumber() {
        assertThat(randomHelper.number((long) 0), is((long) 0));
        assertThat(randomHelper.number(random.nextLong() + 1), not((long) 0));
    }
}

