package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import java.util.Locale

class Lorem(data: FakerData?) : FakerComponent(data!!) {
    fun word(): String {
        return fetch("lorem.words")
    }

    fun supplemental(): String {
        return fetch("lorem.supplemental")
    }

    fun words(num: Int = DEFAULT_NUM, supplemental: Boolean = DEFAULT_SUPPLEMENTAL): List<String> {
        val words: MutableList<String> = ArrayList(num)
        for (i in 0 until num) {
            if (supplemental && randomHelper.randBoolean()) {
                words.add(supplemental())
            } else {
                words.add(word())
            }
        }
        return words
    }

    fun character(): String {
        return ('a'.code + randomHelper.number(26)).toChar().toString()
    }

    fun characters(count: Int = DEFAULT_CHAR_COUNT): String {
        val characters = StringBuilder()
        for (i in 0 until count) {
            characters.append(character())
        }
        return characters.toString()
    }

    fun sentence(
        wordCount: Int = DEFAULT_WORD_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL,
        randomWordsToAdd: Int = DEFAULT_WORDS_TO_ADD
    ): String {
        val finalWordCount = wordCount + randomHelper.number(randomWordsToAdd + 1)
        val words = words(finalWordCount, supplemental)
        var sentence = stringHelper.join(words, " ") + "."
        sentence = sentence.substring(0, 1).uppercase(Locale.getDefault()) + sentence.substring(1) // capitalize
        return sentence
    }

    fun sentences(
        sentenceCount: Int = DEFAULT_SENTENCE_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL
    ): List<String> {
        val sentences: MutableList<String> = ArrayList(sentenceCount)
        for (i in 0 until sentenceCount) {
            sentences.add(sentence(DEFAULT_WORD_COUNT, supplemental))
        }
        return sentences
    }

    fun paragraph(
        sentenceCount: Int = DEFAULT_SENTENCE_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL,
        randomSentencesToAdd: Int = DEFAULT_SENTENCES_TO_ADD
    ): String {
        val finalSentenceCount = sentenceCount + randomHelper.number(randomSentencesToAdd + 1)
        val sentences = sentences(finalSentenceCount, supplemental)
        return stringHelper.join(sentences, " ")
    }

    fun paragraphs(
        paragraphCount: Int = DEFAULT_PARAGRAPH_COUNT,
        supplemental: Boolean = DEFAULT_SUPPLEMENTAL
    ): List<String> {
        val paragraphs: MutableList<String> = ArrayList(paragraphCount)
        for (i in 0 until paragraphCount) {
            paragraphs.add(paragraph(DEFAULT_SENTENCE_COUNT, supplemental))
        }
        return paragraphs
    }

    fun question(wordCount: Int = 4, supplemental: Boolean = false, randomWordsToAdd: Int = 6): String {
        val finalWordCount = wordCount + randomHelper.number(randomWordsToAdd + 1)
        val questionWords = words(finalWordCount, supplemental)
        var sentence = stringHelper.join(questionWords, " ")
        sentence = sentence.substring(0, 1).uppercase(Locale.getDefault()) + sentence.substring(1) // capitalize
        return "$sentence?"
    }

    fun questions(questionsCount: Int = 3, supplemental: Boolean = false): List<String> {
        val questions: MutableList<String> = ArrayList(questionsCount)
        for (i in 0 until questionsCount) {
            questions.add(question(3, supplemental))
        }
        return questions
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