package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class App extends FakerComponent {

    public App(FakerData data) {
        super(data);
    }

    public String name() {
        return sample("name");
    }

    public String version() {
        return numerify(sample("version"));
    }

    public String author() {
        return parse(sample("author"));
    }
}