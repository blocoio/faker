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
    public void setUp() {
        faker = new Faker("en-US");
    }

    @Test
    public void phoneNumber() {
        assertNotNull(faker.phoneNumber.phoneNumber());
    }

    @Test
    public void cellPhone() {
        assertNotNull(faker.phoneNumber.cellPhone());
    }

    @Test
    public void areaCode() {
        assertNotNull(faker.phoneNumber.areaCode());
    }

    @Test
    public void exchangeCode() {
        assertNotNull(faker.phoneNumber.exchangeCode());
    }

    @Test
    public void subscriberNumberDefault() {
        assertNotNull(faker.phoneNumber.subscriberNumber());
    }

    @Test
    public void subscriberNumber() {
        assertThat(faker.phoneNumber.subscriberNumber(10).length(), is(equalTo(10)));
    }

    @Test
    public void extensionDefault() {
        assertNotNull(faker.phoneNumber.subscriberNumber());
    }

    @Test
    public void extension() {
        assertThat(faker.phoneNumber.extension(10).length(), is(equalTo(10)));
    }
}
