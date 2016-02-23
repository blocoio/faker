package io.bloco.faker.components;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import io.bloco.faker.Faker;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class InternetTest {

    private static final String EMAIL_PREFIX_REGEXP = "[\\w\\-\\.]+";
    private static final String EMAIL_SUFFIX_REGEXP = "[\\w-\\.]+";
    private static final String EMAIL_REGEXP = EMAIL_PREFIX_REGEXP + "@" + EMAIL_SUFFIX_REGEXP;

    private Faker faker;

    @Before
    public void setUp() throws Exception {
        faker = new Faker();
    }

    @Test
    public void email() throws Exception {
        assertThat(faker.internet.email(), matchesPattern(EMAIL_REGEXP));
        assertThat(faker.internet.email(null), matchesPattern(EMAIL_REGEXP));
        assertThat(faker.internet.email("test"), matchesPattern("test@" + EMAIL_SUFFIX_REGEXP));
    }

    @Test
    public void freeEmail() throws Exception {
        assertThat(faker.internet.freeEmail(), matchesPattern(EMAIL_REGEXP));
        assertThat(faker.internet.freeEmail(null), matchesPattern(EMAIL_REGEXP));
        assertThat(faker.internet.freeEmail("test"), matchesPattern("test@" + EMAIL_SUFFIX_REGEXP));
    }

    @Test
    public void safeEmail() throws Exception {
        assertThat(faker.internet.safeEmail(),
                matchesPattern(EMAIL_PREFIX_REGEXP + "@example.\\w{3}"));
        assertThat(faker.internet.safeEmail(null),
                matchesPattern(EMAIL_PREFIX_REGEXP + "@example.\\w{3}"));
        assertThat(faker.internet.safeEmail("test"), matchesPattern("test@example.\\w{3}"));
    }

    @Test
    public void userName() throws Exception {
        assertThat(faker.internet.userName(), matchesPattern("[\\w\\_\\.]+"));
        assertThat(faker.internet.userName("Sérgio Santos"),
                matchesPattern("sergio[\\_\\.]santos"));
        assertThat(faker.internet.userName("Sérgio Santos", Arrays.asList("&")),
                matchesPattern("sergio&santos"));
        assertThat(faker.internet.userName(null, Arrays.asList("&")),
                matchesPattern("\\w+(&\\w+)?"));
    }

    @Test
    public void password() throws Exception {
        assertNotNull(faker.internet.password());
        assertThat(faker.internet.password(1).length(), is(greaterThanOrEqualTo(1)));

        assertThat(faker.internet.password(2, 4).length(),
                allOf(greaterThanOrEqualTo(2), lessThanOrEqualTo(4)));
        assertThat(faker.internet.password(2, 2).length(), is(2));

        assertThat(faker.internet.password(2, 2, true),
                allOf(matchesPattern(".*[a-z].*"), matchesPattern(".*[A-Z].*")));

        assertThat(faker.internet.password(2, 2, true, true),
                matchesPattern(".*[\\!\\@\\#\\$\\%\\^\\&\\*].*"));
        assertThat(faker.internet.password(2, 2, true, true).length(), is(2));
    }

    @Test
    public void domainName() throws Exception {
        assertThat(faker.internet.domainName(), matchesPattern("[\\w\\.\\-]+\\.[\\w\\.\\-]+"));
    }

    @Test
    public void domainWord() throws Exception {
        assertThat(faker.internet.domainWord(), matchesPattern("[\\w\\.\\-]+"));
    }

    @Test
    public void domainSuffix() throws Exception {
        assertThat(faker.internet.domainSuffix(), matchesPattern("[\\w\\.\\-]+"));
    }

    @Test
    public void macAddress() throws Exception {
        assertThat(faker.internet.macAddress(), matchesPattern("[0-9a-f]{2}(:[0-9a-f]{2}){5}"));
        assertThat(faker.internet.macAddress("ff"), matchesPattern("ff(:[0-9a-f]{2}){5}"));
        assertThat(faker.internet.macAddress("ff:ee"), matchesPattern("ff:ee(:[0-9a-f]{2}){4}"));
    }

    @Test
    public void ipV4Address() throws Exception {
        assertThat(faker.internet.ipV4Address(), matchesPattern("[0-9]{1,3}(\\.[0-9]{1,3}){3}"));
    }

    @Test
    public void ipV4Cidr() throws Exception {
        assertThat(faker.internet.ipV4Cidr(),
                matchesPattern("\\d{1,3}(\\.\\d{1,3}){3}/\\d{1,2}"));
    }

    @Test
    public void ipV6Address() throws Exception {
        assertThat(faker.internet.ipV6Address(),
                matchesPattern("[0-9a-f]{1,4}(:[0-9a-f]{1,4}){7}"));
    }

    @Test
    public void ipV6Cidr() throws Exception {
        assertThat(faker.internet.ipV6Cidr(),
                matchesPattern("[0-9a-f]{1,4}(:[0-9a-f]{1,4}){7}/\\d{1,3}"));
    }

    @Test
    public void url() throws Exception {
        assertThat(faker.internet.url(), matchesPattern("http://[\\w\\.\\-]+/[\\w\\.\\-]+"));
        assertThat(faker.internet.url("example.com"),
                matchesPattern("http://example\\.com/[\\w\\.\\-]+"));
        assertThat(faker.internet.url("example.com", "/hello"),
                is(equalTo("http://example.com/hello")));
    }

    @Test
    public void slug() throws Exception {
        assertThat(faker.internet.slug(), matchesPattern("\\w+([\\.\\_\\-]\\w+)+"));
        assertThat(faker.internet.slug(Arrays.asList("a", "b")), matchesPattern("a[\\.\\_\\-]b"));
        assertThat(faker.internet.slug(Arrays.asList("a", "b"), "&"), is(equalTo("a&b")));
    }

    @Test
    public void deviceToken() throws Exception {
        assertThat(faker.internet.deviceToken(), matchesPattern("[0-9a-f]{64}"));
    }
}
