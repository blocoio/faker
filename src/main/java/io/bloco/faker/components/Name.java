package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Name extends FakerComponent {

    public Name(FakerData data) {
        super(data);
    }

    public String firstName() {
        return sample("first_name");
    }

    public String lastName() {
        return sample("last_name");
    }

    public String prefix() {
        return sample("prefix");
    }

    public String suffix() {
        return sample("suffix");
    }

    public String title() {
        return sample("title.descriptor") + " " + sample("title.level") + " " + sample("title.job");
    }

    public String name() {
        return parse(sample("name"));
    }
}