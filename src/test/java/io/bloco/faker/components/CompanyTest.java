package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import io.bloco.faker.Faker;

import static org.junit.Assert.assertNotNull;

public class CompanyTest {

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void testSuffix() throws Exception {
        assertNotNull(faker.company.suffix());
    }

    @Test
    public void testBuzzwords() throws Exception {
        assertNotNull(faker.company.buzzwords());
    }

    @Test
    public void testBs() throws Exception {
        assertNotNull(faker.company.bs());
    }

    @Test
    public void testName() throws Exception {
        assertNotNull(faker.company.name());
    }

    @Test
    public void testIndustry() throws Exception {
        assertNotNull(faker.company.industry());
    }

    @Test
    public void testProfession() throws Exception {
        assertNotNull(faker.company.profession());
    }

}
