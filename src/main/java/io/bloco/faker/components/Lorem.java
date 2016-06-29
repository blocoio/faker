package io.bloco.faker.components;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Lorem extends FakerComponent {

    private static final int DEFAULT_NUM = 3;
    private static final boolean DEFAULT_SUPPLEMENTAL = false;
    private static final int DEFAULT_CHAR_COUNT = 255;
    private static final int DEFAULT_WORD_COUNT = 4;
    private static final int DEFAULT_WORDS_TO_ADD = 6;
    private static final int DEFAULT_SENTENCE_COUNT = 3;
    private static final int DEFAULT_SENTENCES_TO_ADD = 3;
    private static final int DEFAULT_PARAGRAPH_COUNT = 3;

    public Lorem(FakerData data) {
        super(data);
    }

    public String word() {
        return fetch("lorem.words");
    }

    public String supplemental() {
        return fetch("lorem.supplemental");
    }

    public List<String> words() {
        return words(DEFAULT_NUM);
    }

    public List<String> words(int num) {
        return words(num, DEFAULT_SUPPLEMENTAL);
    }

    public List<String> words(int num, boolean supplemental) {
        List<String> words = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            if (supplemental && randomHelper.randBoolean()) {
                words.add(supplemental());
            } else {
                words.add(word());
            }
        }
        return words;
    }

    public String character() {
        return Character.toString((char) ('a' + randomHelper.number(26)));
    }

    public String characters() {
        return characters(DEFAULT_CHAR_COUNT);
    }

    public String characters(int count) {
        StringBuilder characters = new StringBuilder();
        for (int i = 0; i < count; i++) {
            characters.append(character());
        }
        return characters.toString();
    }

    public String sentence() {
        return sentence(DEFAULT_WORD_COUNT);
    }

    public String sentence(int wordCount) {
        return sentence(wordCount, DEFAULT_SUPPLEMENTAL);
    }

    public String sentence(int wordCount, boolean supplemental) {
        return sentence(wordCount, supplemental, DEFAULT_WORDS_TO_ADD);
    }

    public String sentence(int wordCount, boolean supplemental, int randomWordsToAdd) {
        int finalWordCount = wordCount + randomHelper.number(randomWordsToAdd + 1);
        List<String> words = words(finalWordCount, supplemental);
        String sentence = stringHelper.join(words, " ") + ".";
        sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1); // capitalize
        return sentence;
    }

    public List<String> sentences() {
        return sentences(DEFAULT_SENTENCE_COUNT, DEFAULT_SUPPLEMENTAL);
    }

    public List<String> sentences(int sentenceCount) {
        return sentences(sentenceCount, DEFAULT_SUPPLEMENTAL);
    }

    public List<String> sentences(int sentenceCount, boolean supplemental) {
        List<String> sentences = new ArrayList<>(sentenceCount);
        for (int i = 0; i < sentenceCount; i++) {
            sentences.add(sentence(DEFAULT_WORD_COUNT, supplemental));
        }
        return sentences;
    }

    public String paragraph() {
        return paragraph(DEFAULT_SENTENCE_COUNT);
    }

    public String paragraph(int sentenceCount) {
        return paragraph(sentenceCount, DEFAULT_SUPPLEMENTAL);
    }

    public String paragraph(int sentenceCount, boolean supplemental) {
        return paragraph(sentenceCount, supplemental, DEFAULT_SENTENCES_TO_ADD);
    }

    public String paragraph(int sentenceCount, boolean supplemental, int randomSentencesToAdd) {
        int finalSentenceCount = sentenceCount + randomHelper.number(randomSentencesToAdd + 1);
        List<String> sentences = sentences(finalSentenceCount, supplemental);
        return stringHelper.join(sentences, " ");
    }

    public List<String> paragraphs() {
        return paragraphs(DEFAULT_PARAGRAPH_COUNT);
    }

    public List<String> paragraphs(int paragraphCount) {
        return paragraphs(paragraphCount, DEFAULT_SUPPLEMENTAL);
    }

    public List<String> paragraphs(int paragraphCount, boolean supplemental) {
        List<String> paragraphs = new ArrayList<>(paragraphCount);
        for (int i = 0; i < paragraphCount; i++) {
            paragraphs.add(paragraph(DEFAULT_SENTENCE_COUNT, supplemental));
        }
        return paragraphs;
    }

    public String question() {
        return question(4);
    }

    public String question(int wordCount) {
        return question(wordCount, false);
    }

    public String question(int wordCount, boolean supplemental) {
        return question(wordCount, supplemental, 6);
    }

    public String question(int wordCount, boolean supplemental, int randomWordsToAdd) {
        int finalWordCount = wordCount + randomHelper.number(randomWordsToAdd + 1);
        List<String> questionWords = words(finalWordCount, supplemental);
        String sentence = stringHelper.join(questionWords, " ");
        sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1); // capitalize
        return sentence + "?";
    }

    public List<String> questions() {
        return questions(3);
    }

    public List<String> questions(int questionsCount) {
        return questions(questionsCount, false);
    }

    public List<String> questions(int questionsCount, boolean supplemental) {
        List<String> questions = new ArrayList<>(questionsCount);
        for (int i = 0; i < questionsCount; i++) {
            questions.add(question(3, supplemental));
        }
        return questions;
    }
}
