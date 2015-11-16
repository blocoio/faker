package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class PhoneNumberTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker("en-US");
    }

    @Test
    public void phoneNumber() throws Exception {
        assertNotNull(faker.phoneNumber.phoneNumber());
    }

    @Test
    public void cellPhone() throws Exception {
        assertNotNull(faker.phoneNumber.cellPhone());
    }

    @Test
    public void areaCode() throws Exception {
        assertNotNull(faker.phoneNumber.areaCode());
    }

    @Test
    public void exchangeCode() throws Exception {
        assertNotNull(faker.phoneNumber.exchangeCode());
    }

    @Test
    public void subscriberNumberDefault() throws Exception {
        assertNotNull(faker.phoneNumber.subscriberNumber());
    }

    @Test
    public void subscriberNumber() throws Exception {
        assertThat(faker.phoneNumber.subscriberNumber(10).length(), is(equalTo(10)));
    }

    @Test
    public void extensionDefault() throws Exception {
        assertNotNull(faker.phoneNumber.subscriberNumber());
    }

    @Test
    public void extension() throws Exception {
        assertThat(faker.phoneNumber.extension(10).length(), is(equalTo(10)));
    }
}
