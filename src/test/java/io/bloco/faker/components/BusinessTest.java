package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BusinessTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void creditCardNumber() throws Exception {
        assertNotNull(faker.business.creditCardNumber());
    }

    @Test
    public void creditCardExpireDate() throws Exception {
        Date date = faker.business.creditCardExpireDate();
        Date today = new GregorianCalendar().getTime();
        assertTrue(date.after(today));
    }

    @Test
    public void creditCardType() throws Exception {
        assertNotNull(faker.business.creditCardType());
    }
}
