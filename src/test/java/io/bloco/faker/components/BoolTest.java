package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static junit.framework.TestCase.assertEquals;

public class BoolTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void bool() throws Exception {
        float trueRatio = Math.round(Math.random() * 10f) / 10f;
        int times = 1000;
        int trueCounter = 0;

        for (int i = 0; i < times; i++) {
            if (faker.bool.bool(trueRatio)) {
                trueCounter++;
            }
        }

        assertEquals(trueCounter / (float) times, trueRatio, 0.1);
    }
}
