package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Book extends FakerComponent {

    public Book(FakerData data) {
        super(data);
    }

    public String title() {
        return sample("title");
    }

    public String author() {
        return parse("title");
    }

    public String publisher() {
        return sample("publisher");
    }

    public String genre() {
        return sample("genre");
    }
}
