package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Book(data: FakerData) : FakerComponent(data) {
    fun title(): String {
        return fetch("book.title")
    }

    fun author(): String {
        return parse("book.title")
    }

    fun publisher(): String {
        return fetch("book.publisher")
    }

    fun genre(): String {
        return fetch("book.genre")
    }
}
