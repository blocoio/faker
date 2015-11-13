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
    public void suffix() throws Exception {
        assertNotNull(faker.company.suffix());
    }

    @Test
    public void buzzwords() throws Exception {
        assertNotNull(faker.company.buzzwords());
    }

    @Test
    public void bs() throws Exception {
        assertNotNull(faker.company.bs());
    }

    @Test
    public void name() throws Exception {
        assertNotNull(faker.company.name());
    }

    @Test
    public void industry() throws Exception {
        assertNotNull(faker.company.industry());
    }

    @Test
    public void profession() throws Exception {
        assertNotNull(faker.company.profession());
    }

}
