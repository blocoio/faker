package io.bloco.faker.components;

import java.util.List;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Name extends FakerComponent {

    public Name(FakerData data) {
        super(data);
    }

    public String firstName() {
        return fetch("name.first_name");
    }

    public String lastName() {
        return fetch("name.last_name");
    }

    public String prefix() {
        return fetch("name.prefix");
    }

    public String suffix() {
        return fetch("name.suffix");
    }

    public String title() {
        return fetch("name.title.descriptor")
                + " " + fetch("name.title.level")
                + " " + fetch("name.title.job");
    }

    public String name() {
        return parse(fetch("name.name"));
    }

    public String nameWithMiddle() {
        return parse(fetch("name.name_with_middle"));
    }

    public List<String> jobTitles() {
        return (List<String>) getMap("name", "title").get("job");
    }
}