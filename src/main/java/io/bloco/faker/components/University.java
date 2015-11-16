package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class University extends FakerComponent {

    public University(FakerData data) {
        super(data);
    }

    public String name() {
        return parse(fetch("university.name"));
    }

    public String prefix() {
        return fetch("university.prefix");
    }

    public String suffix() {
        return fetch("university.suffix");
    }
}
