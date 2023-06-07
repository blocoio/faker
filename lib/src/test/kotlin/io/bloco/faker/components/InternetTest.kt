package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

class InternetTest {
    private val faker = Faker()

    @Test
    fun email() {
        assertTrue(faker.internet.email().matches(Regex(EMAIL_REGEXP)))
        assertTrue(faker.internet.email(null).matches(Regex(EMAIL_REGEXP)))
        assertTrue(faker.internet.email("test").matches(Regex("test@$EMAIL_SUFFIX_REGEXP")))
    }

    @Test
    fun freeEmail() {
        assertTrue(faker.internet.freeEmail().matches(Regex(EMAIL_REGEXP)))
        assertTrue(faker.internet.freeEmail(null).matches(Regex(EMAIL_REGEXP)))
        assertTrue(faker.internet.freeEmail("test").matches(Regex("test@$EMAIL_SUFFIX_REGEXP")))
    }

    @Test
    fun safeEmail() {
        assertTrue(faker.internet.safeEmail().matches(Regex("$EMAIL_PREFIX_REGEXP@example.\\w{3}")))
        assertTrue(
            faker.internet.safeEmail(null).matches(Regex("$EMAIL_PREFIX_REGEXP@example.\\w{3}"))
        )
        assertTrue(faker.internet.safeEmail("test").matches(Regex("test@example.\\w{3}")))
    }

    @Test
    fun userName() {
        assertTrue(faker.internet.userName().matches(Regex("[\\w_.]+")))
        assertTrue(faker.internet.userName("Sérgio Santos").matches(Regex("sergio[_.]santos")))
        assertTrue(
            faker.internet.userName("Sérgio Santos", listOf("&")).matches(Regex("sergio&santos"))
        )
        assertTrue(faker.internet.userName(null, listOf("&")).matches(Regex("\\w+(&\\w+)?")))
    }

    @Test
    fun password() {
        assertNotNull(faker.internet.password())
        assertTrue(faker.internet.password(1).isNotEmpty())
        assertTrue(faker.internet.password(2, 4).length in 2..4)
        assertTrue(faker.internet.password(2, 2).length == 2)
        assertTrue(
            faker.internet.password(2, 2, mixCase = true, specialChars = true)
                .matches(Regex(".*[!@#$%^&*].*"))
        )
        assertTrue(faker.internet.password(2, 2, mixCase = true, specialChars = true).length == 2)

        assertTrue(faker.internet.password(2, 2, true).matches(Regex(".*[A-Z].*")))
    }

    @Test
    fun domainName() {
        assertTrue(faker.internet.domainName().matches(Regex("[\\w.\\-]+\\.[\\w.\\-]+")))
    }

    @Test
    fun domainWord() {
        assertTrue(faker.internet.domainWord().matches(Regex("[\\w.\\-]+")))
    }

    @Test
    fun domainSuffix() {
        assertTrue(faker.internet.domainSuffix().matches(Regex("[\\w.\\-]+")))
    }

    @Test
    fun macAddress() {
        assertTrue(faker.internet.macAddress().matches(Regex("[\\da-f]{2}(:[\\da-f]{2}){5}")))
        assertTrue(faker.internet.macAddress("ff").matches(Regex("ff(:[\\da-f]{2}){5}")))
        assertTrue(faker.internet.macAddress("ff:ee").matches(Regex("ff:ee(:[\\da-f]{2}){4}")))
    }

    @Test
    fun ipV4Address() {
        assertTrue(faker.internet.ipV4Address().matches(Regex("\\d{1,3}(\\.\\d{1,3}){3}")))
    }

    @Test
    fun ipV4Cidr() {
        assertTrue(faker.internet.ipV4Cidr().matches(Regex("\\d{1,3}(\\.\\d{1,3}){3}/\\d{1,2}")))
    }

    @Test
    fun ipV6Address() {
        assertTrue(faker.internet.ipV6Address().matches(Regex("[\\da-f]{1,4}(:[\\da-f]{1,4}){7}")))
    }

    @Test
    fun ipV6Cidr() {
        assertTrue(
            faker.internet.ipV6Cidr().matches(Regex("[\\da-f]{1,4}(:[\\da-f]{1,4}){7}/\\d{1,3}"))
        )
    }

    @Test
    fun url() {
        assertTrue(faker.internet.url().matches(Regex("http://[\\w.\\-]+/[\\w.\\-]+")))
        assertTrue(
            faker.internet.url("example.com").matches(Regex("http://example\\.com/[\\w.\\-]+"))
        )
        assertTrue(faker.internet.url("example.com", "/hello") == "http://example.com/hello")
    }

    @Test
    fun slug() {
        assertTrue(faker.internet.slug().matches(Regex("\\w+([._\\-]\\w+)+")))
        assertTrue(faker.internet.slug(listOf("a", "b")).matches(Regex("a[._\\-]b")))
        assertTrue(faker.internet.slug(listOf("a", "b"), "&") == "a&b")
    }

    @Test
    fun deviceToken() {
        assertTrue(faker.internet.deviceToken().matches(Regex("[\\da-f]{64}")))
    }

    companion object {
        private const val EMAIL_PREFIX_REGEXP = "[\\w\\-\\.]+"
        private const val EMAIL_SUFFIX_REGEXP = "[\\w-\\.]+"
        private const val EMAIL_REGEXP = "$EMAIL_PREFIX_REGEXP@$EMAIL_SUFFIX_REGEXP"
    }
}