package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class App extends FakerComponent {

    public App(FakerData data) {
        super(data);
    }

    public String name() {
        return fetch("app.name");
    }

    public String version() {
        return numerify(fetch("app.version"));
    }

    public String author() {
        return parse(fetch("app.author"));
    }
}