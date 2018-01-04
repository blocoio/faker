package io.bloco.faker.components;

import io.bloco.faker.Faker;
import org.junit.Before;
import org.junit.Test;

import static io.bloco.faker.test_helpers.RegularExpressionMatcher.matchesPattern;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class LoremTest {

    private Faker faker;

    @Before
    public void setUp() {
        faker = new Faker();
    }

    @Test
    public void word() {
        assertNotNull(faker.lorem.word());
    }

    @Test
    public void supplemental() {
        assertNotNull(faker.lorem.supplemental());
    }

    @Test
    public void wordsDefault() {
        assertThat(faker.lorem.words().size(), is(not(equalTo(0))));
    }

    @Test
    public void words() {
        assertThat(faker.lorem.words(1).size(), is(equalTo(1)));
        assertThat(faker.lorem.words(10, true).size(), is(equalTo(10)));
    }

    @Test
    public void character() {
        assertThat(faker.lorem.character(), matchesPattern("\\w"));
    }

    @Test
    public void characters() {
        assertThat(faker.lorem.characters(10), matchesPattern("\\w{10}"));
    }

    @Test
    public void charactersDefault() {
        assertThat(faker.lorem.characters().length(), is(not(equalTo(0))));
    }

    @Test
    public void sentenceDefault() {
        assertNotNull(faker.lorem.sentence());
        assertNotNull(faker.lorem.sentence(4));
        assertNotNull(faker.lorem.sentence(4, false));
    }

    @Test
    public void sentence() {
        assertThat(faker.lorem.sentence(4, true, 0), matchesPattern("[A-Z]\\w*( \\w+){3}\\."));
        assertThat(faker.lorem.sentence(1, true, 4), matchesPattern("[A-Z]\\w*( \\w+){0,4}\\."));
    }

    @Test
    public void sentencesDefault() {
        assertNotNull(faker.lorem.sentences());
        assertNotNull(faker.lorem.sentences(4));
    }

    @Test
    public void sentences() {
        assertThat(faker.lorem.sentences(1, false).size(), is(equalTo(1)));
        assertThat(faker.lorem.sentences(10, false).size(), is(equalTo(10)));
    }

    @Test
    public void paragraphDefault() {
        assertNotNull(faker.lorem.paragraph());
        assertNotNull(faker.lorem.paragraph(4));
        assertNotNull(faker.lorem.paragraph(4, false));
    }

    @Test
    public void paragraph() {
        assertThat(faker.lorem.paragraph(4, true, 0), matchesPattern("([^\\.]+\\.){4}"));
        assertThat(faker.lorem.paragraph(1, true, 4), matchesPattern("([^\\.]+\\.){1,5}"));
    }

    @Test
    public void paragraphsDefault() {
        assertNotNull(faker.lorem.paragraphs());
        assertNotNull(faker.lorem.paragraphs(4));
    }

    @Test
    public void paragraphs() {
        assertThat(faker.lorem.paragraphs(1, false).size(), is(equalTo(1)));
        assertThat(faker.lorem.paragraphs(10, false).size(), is(equalTo(10)));
    }

    @Test
    public void questionDefault() {
        assertNotNull(faker.lorem.question());
        assertNotNull(faker.lorem.question(4));
        assertNotNull(faker.lorem.question(4, false));
    }

    @Test
    public void question() {
        assertThat(faker.lorem.question(4, true, 0), matchesPattern("[A-Z]\\w*( \\w+){3}\\?"));
        assertThat(faker.lorem.question(1, true, 4), matchesPattern("[A-Z]\\w*( \\w+){0,4}\\?"));
    }

    @Test
    public void questionsDefault() {
        assertNotNull(faker.lorem.questions());
        assertNotNull(faker.lorem.questions(4));
    }

    @Test
    public void questions() {
        assertThat(faker.lorem.questions(1, false).size(), is(equalTo(1)));
        assertThat(faker.lorem.questions(10, false).size(), is(equalTo(10)));
    }
}
