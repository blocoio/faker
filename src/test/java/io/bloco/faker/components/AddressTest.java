package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class AddressTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void testCityPrefix() throws Exception {
        assertNotNull(faker.address.cityPrefix());
    }

    @Test
    public void citySuffix() throws Exception {
        assertNotNull(faker.address.citySuffix());
    }

    @Test
    public void country() throws Exception {
        assertNotNull(faker.address.country());
    }

    @Test
    public void countryCode() throws Exception {
        assertNotNull(faker.address.countryCode());
    }

    @Test
    public void buildingNumber() throws Exception {
        assertNotNull(faker.address.buildingNumber());
    }
    @Test
    public void streetSuffix() throws Exception {
        assertNotNull(faker.address.streetSuffix());
    }

    @Test
    public void secondaryAddress() throws Exception {
        assertNotNull(faker.address.secondaryAddress());
    }

    @Test
    public void postcode() throws Exception {
        assertNotNull(faker.address.postcode());
    }

    @Test
    public void state() throws Exception {
        assertNotNull(faker.address.state());
    }

    @Test
    public void stateAbbr() throws Exception {
        assertNotNull(faker.address.stateAbbr());
    }

    @Test
    public void timeZone() throws Exception {
        assertNotNull(faker.address.timeZone());
    }

    @Test
    public void city() throws Exception {
        assertNotNull(faker.address.city());
    }

    @Test
    public void streetName() throws Exception {
        assertNotNull(faker.address.streetName());
    }

    @Test
    public void streetAddress() throws Exception {
        assertNotNull(faker.address.streetAddress());
    }

    @Test
    public void defaultCountry() throws Exception {
        assertNotNull(faker.address.defaultCountry());
    }
}
