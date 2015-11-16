package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Book extends FakerComponent {

    public Book(FakerData data) {
        super(data);
    }

    public String title() {
        return fetch("book.title");
    }

    public String author() {
        return parse("book.title");
    }

    public String publisher() {
        return fetch("book.publisher");
    }

    public String genre() {
        return fetch("book.genre");
    }
}
