package io.bloco.faker.components;

import java.util.Map;

import io.bloco.faker.FakerComponent;

public class App extends FakerComponent {

    public static final String KEY = "app";

    public App(Map<String, Object> data) {
        super(data);
    }

    public String name() {
        return sample("name");
    }

    private String version() {
        return numerify(sample("name"));
    }

    private String author() {
        throw new UnsupportedOperationException();
    }
}