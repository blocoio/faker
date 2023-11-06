package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

class NameTest {
    private val faker = Faker()

    @Test
    fun firstName() {
        assertNotNull(faker.name.firstName())
    }

    @Test
    fun lastName() {
        assertNotNull(faker.name.lastName())
    }

    @Test
    fun prefix() {
        assertNotNull(faker.name.prefix())
    }

    @Test
    fun suffix() {
        assertNotNull(faker.name.suffix())
    }

    @Test
    fun title() {
        assertNotNull(faker.name.title())
    }

    @Test
    fun name() {
        assertNotNull(faker.name.name())
    }

    @Test
    fun name_ru() {
        val name = Faker("ru").name.name()
        assertNotNull(name)
        assertFalse(name.contains("#"))
    }

    @Test
    fun nameWithMiddle() {
        assertNotNull(faker.name.nameWithMiddle())
    }

    @Test
    fun jobTitles() {
        assertTrue(faker.name.jobTitles().contains("Engineer"))
    }
}
