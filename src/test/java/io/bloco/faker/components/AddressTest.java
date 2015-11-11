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
    public void testCitySuffix() throws Exception {
        assertNotNull(faker.address.citySuffix());
    }

    @Test
    public void testCountry() throws Exception {
        assertNotNull(faker.address.country());
    }

    @Test
    public void testCountryCode() throws Exception {
        assertNotNull(faker.address.countryCode());
    }

    @Test
    public void testBuildingNumber() throws Exception {
        assertNotNull(faker.address.buildingNumber());
    }
    @Test
    public void testStreetSuffix() throws Exception {
        assertNotNull(faker.address.streetSuffix());
    }

    @Test
    public void testSecondaryAddress() throws Exception {
        assertNotNull(faker.address.secondaryAddress());
    }

    @Test
    public void testPostcode() throws Exception {
        assertNotNull(faker.address.postcode());
    }

    @Test
    public void testPostcodeByState() throws Exception {
        assertNotNull(faker.address.postcodeByState());
    }

    @Test
    public void testState() throws Exception {
        assertNotNull(faker.address.state());
    }

    @Test
    public void testStateAbbr() throws Exception {
        assertNotNull(faker.address.stateAbbr());
    }

    @Test
    public void testTimeZone() throws Exception {
        assertNotNull(faker.address.timeZone());
    }

    @Test
    public void testCity() throws Exception {
        assertNotNull(faker.address.city());
    }

    @Test
    public void testStreetName() throws Exception {
        assertNotNull(faker.address.streetName());
    }

    @Test
    public void testStreetAddress() throws Exception {
        assertNotNull(faker.address.streetAddress());
    }

    @Test
    public void testDefaultCountry() throws Exception {
        assertNotNull(faker.address.defaultCountry());
    }
}
