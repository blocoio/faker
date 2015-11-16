package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Company extends FakerComponent {

    public Company(FakerData data) {
        super(data);
    }

    public String suffix() {
        return fetch("company.suffix");
    }

    public String buzzwords() {
        return fetch("company.buzzwords");
    }

    public String bs() {
        return fetch("company.bs");
    }

    public String name() {
        return parse(fetch("company.name"));
    }

    public String industry() {
        return fetch("company.industry");
    }

    public String profession() {
        return fetch("company.profession");
    }
}
