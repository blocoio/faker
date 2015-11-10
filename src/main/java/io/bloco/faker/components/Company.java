package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Company extends FakerComponent {

    public Company(FakerData data) {
        super(data);
    }

    public String suffix() {
        return sample("suffix");
    }

    public String buzzwords() {
        return sample("buzzwords");
    }

    public String bs() {
        return sample("bs");
    }

    public String name() {
        return parse(sample("name"));
    }

    public String industry() {
        return sample("industry");
    }

    public String profession() {
        return sample("profession");
    }
}
