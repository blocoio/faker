package io.bloco.faker.components;

import java.util.List;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Company extends FakerComponent {

    public Company(FakerData data) {
        super(data);
    }

    public String name() {
        return parse(fetch("company.name"));
    }

    public String suffix() {
        return fetch("company.suffix");
    }

    public String industry() {
        return fetch("company.industry");
    }

    public String catchPhrase() {
        List buzzwordsSections = getList("company", "buzzwords");
        String catchPhrase = "";
        for (Object buzzwordsSection : buzzwordsSections) {
            catchPhrase += sampleFromList((List) buzzwordsSection) + " ";
        }
        return catchPhrase.substring(0, catchPhrase.length() - 1);
    }

    public String buzzwords() {
        return fetch("company.buzzwords");
    }

    public String bs() {
        return fetch("company.bs");
    }

    public String logo() {
        int randomNum = randomHelper.range(1, 12);
        return "https://pigment.github.io/fake-logos/logos/medium/color/" + randomNum + ".png";
    }

    public String profession() {
        return fetch("company.profession");
    }
}
