package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class University extends FakerComponent {

    public University(FakerData data) {
        super(data);
    }

    public String name() {
        return parse(sample("name"));
    }

    public String prefix() {
        return sample("prefix");
    }

    public String suffix() {
        return sample("suffix");
    }
}
