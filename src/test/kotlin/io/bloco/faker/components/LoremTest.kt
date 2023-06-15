package io.bloco.faker.components

import io.bloco.faker.Faker
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import org.junit.Test

class LoremTest {
    private val faker = Faker()

    @Test
    fun word() {
        assertNotNull(faker.lorem.word())
    }

    @Test
    fun supplemental() {
        assertNotNull(faker.lorem.supplemental())
    }

    @Test
    fun wordsDefault() {
        assertTrue(faker.lorem.words().isNotEmpty())
    }

    @Test
    fun words() {
        assertTrue(faker.lorem.words(1).size == 1)
        assertTrue(faker.lorem.words(10, true).size == 10)
    }

    @Test
    fun character() {
        assertTrue(faker.lorem.character().matches(Regex("\\w")))
    }

    @Test
    fun characters() {
        assertTrue(faker.lorem.characters(10).matches(Regex("\\w{10}")))
    }

    @Test
    fun charactersDefault() {
        assertTrue(faker.lorem.characters().isNotEmpty())
    }

    @Test
    fun sentenceDefault() {
        assertNotNull(faker.lorem.sentence())
        assertNotNull(faker.lorem.sentence(4))
        assertNotNull(faker.lorem.sentence(4, false))
    }

    @Test
    fun sentence() {
        assertTrue(faker.lorem.sentence(4, true, 0).matches(Regex("[A-Z]\\w*( \\w+){3}\\.")))
        assertTrue(faker.lorem.sentence(1, true, 4).matches(Regex("[A-Z]\\w*( \\w+){0,4}\\.")))
    }

    @Test
    fun sentencesDefault() {
        assertNotNull(faker.lorem.sentences())
        assertNotNull(faker.lorem.sentences(4))
    }

    @Test
    fun sentences() {
        assertTrue(faker.lorem.sentences(1, false).size == 1)
        assertTrue(faker.lorem.sentences(10, false).size == 10)
    }

    @Test
    fun paragraphDefault() {
        assertNotNull(faker.lorem.paragraph())
        assertNotNull(faker.lorem.paragraph(4))
        assertNotNull(faker.lorem.paragraph(4, false))
    }

    @Test
    fun paragraph() {
        assertTrue(faker.lorem.paragraph(4, true, 0).matches(Regex("([^\\.]+\\.){4}")))
        assertTrue(faker.lorem.paragraph(1, true, 4).matches(Regex("([^\\.]+\\.){1,5}")))
    }

    @Test
    fun paragraphsDefault() {
        assertNotNull(faker.lorem.paragraphs())
        assertNotNull(faker.lorem.paragraphs(4))
    }

    @Test
    fun paragraphs() {
        assertTrue(faker.lorem.paragraphs(1, false).size == 1)
        assertTrue(faker.lorem.paragraphs(10, false).size == 10)
    }

    @Test
    fun questionDefault() {
        assertNotNull(faker.lorem.question())
        assertNotNull(faker.lorem.question(4))
        assertNotNull(faker.lorem.question(4, false))
    }

    @Test
    fun question() {
        assertTrue(faker.lorem.question(4, true, 0).matches(Regex("[A-Z]\\w*( \\w+){3}\\?")))
        assertTrue(faker.lorem.question(1, true, 4).matches(Regex("[A-Z]\\w*( \\w+){0,4}\\?")))
    }

    @Test
    fun questionsDefault() {
        assertNotNull(faker.lorem.questions())
        assertNotNull(faker.lorem.questions(4))
    }

    @Test
    fun questions() {
        assertTrue(faker.lorem.questions(1, false).size == 1)
        assertTrue(faker.lorem.questions(10, false).size == 10)
    }
}
