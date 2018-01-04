package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class AddressTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void testCityPrefix() {
        assertNotNull(faker.address.cityPrefix());
    }

    @Test
    public void citySuffix() {
        assertNotNull(faker.address.citySuffix());
    }

    @Test
    public void country() {
        assertNotNull(faker.address.country());
    }

    @Test
    public void countryCode() {
        assertNotNull(faker.address.countryCode());
    }

    @Test
    public void buildingNumber() {
        assertNotNull(faker.address.buildingNumber());
    }
    @Test
    public void streetSuffix() {
        assertNotNull(faker.address.streetSuffix());
    }

    @Test
    public void secondaryAddress() {
        assertNotNull(faker.address.secondaryAddress());
    }

    @Test
    public void postcode() {
        assertNotNull(faker.address.postcode());
    }

    @Test
    public void state() {
        assertNotNull(faker.address.state());
    }

    @Test
    public void stateAbbr() {
        assertNotNull(faker.address.stateAbbr());
    }

    @Test
    public void timeZone() {
        assertNotNull(faker.address.timeZone());
    }

    @Test
    public void city() {
        assertNotNull(faker.address.city());
    }

    @Test
    public void streetName() {
        assertNotNull(faker.address.streetName());
    }

    @Test
    public void streetAddress() {
        assertNotNull(faker.address.streetAddress());
    }

    @Test
    public void defaultCountry() {
        assertNotNull(faker.address.defaultCountry());
    }
}
