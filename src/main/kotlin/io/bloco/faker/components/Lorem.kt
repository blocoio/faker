package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.RandomHelper

class Lorem(data: FakerData?) : FakerComponent(data!!) {
    fun word(): String {
        return fetch("lorem.words")
    }

    fun supplemental(): String {
        return fetch("lorem.supplemental")
    }

    @JvmOverloads
    fun words(num: Int = DEFAULT_NUM, supplemental: Boolean = DEFAULT_SUPPLEMENTAL): List<String> {
        return List(num) {
            if (supplemental && RandomHelper.randBoolean()) {
                supplemental()
            } else {
                word()
            }
        }
    }

    fun character(): String {
        return ('a' + RandomHelper.number(26)).toString()
    }

    fun characters(count: Int = DEFAULT_CHAR_COUNT): String {
        return List(count) { character() }.joinToString("")
    }

    @JvmOverloads
    fun sentence(
        wordCount: Int = DEFAULT_WORD_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL,
        randomWordsToAdd: Int = DEFAULT_WORDS_TO_ADD
    ): String {
        val finalWordCount = wordCount + RandomHelper.number(randomWordsToAdd + 1)
        val words = words(finalWordCount, supplemental)
        return words.joinToString(separator = " ")
            .replaceFirstChar { it.titlecase() } + "."
    }

    @JvmOverloads
    fun sentences(
        sentenceCount: Int = DEFAULT_SENTENCE_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL
    ): List<String> {
        return List(sentenceCount) { sentence(DEFAULT_WORD_COUNT, supplemental) }
    }

    @JvmOverloads
    fun paragraph(
        sentenceCount: Int = DEFAULT_SENTENCE_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL,
        randomSentencesToAdd: Int = DEFAULT_SENTENCES_TO_ADD
    ): String {
        val finalSentenceCount = sentenceCount + RandomHelper.number(randomSentencesToAdd + 1)
        val sentences = sentences(finalSentenceCount, supplemental)
        return sentences.joinToString(" ")
    }

    @JvmOverloads
    fun paragraphs(
        paragraphCount: Int = DEFAULT_PARAGRAPH_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL
    ): List<String> {
        return List(paragraphCount) { paragraph(DEFAULT_SENTENCE_COUNT, supplemental) }
    }

    @JvmOverloads
    fun question(
        wordCount: Int = 4,
        supplemental: Boolean = false,
        randomWordsToAdd: Int = 6
    ): String {
        val finalWordCount = wordCount + RandomHelper.number(randomWordsToAdd + 1)
        val questionWords = words(finalWordCount, supplemental)
        val sentence = questionWords.joinToString(" ")
            .replaceFirstChar { it.titlecase() }
        return "$sentence?"
    }

    @JvmOverloads
    fun questions(questionsCount: Int = 3, supplemental: Boolean = false): List<String> {
        return List(questionsCount) { question(3, supplemental) }
    }

    companion object {
        private const val DEFAULT_NUM = 3
        private const val DEFAULT_SUPPLEMENTAL = false
        private const val DEFAULT_CHAR_COUNT = 255
        private const val DEFAULT_WORD_COUNT = 4
        private const val DEFAULT_WORDS_TO_ADD = 6
        private const val DEFAULT_SENTENCE_COUNT = 3
        private const val DEFAULT_SENTENCES_TO_ADD = 3
        private const val DEFAULT_PARAGRAPH_COUNT = 3
    }
}
