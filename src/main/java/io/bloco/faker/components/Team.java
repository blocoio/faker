package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Team extends FakerComponent {

    public Team(FakerData data) {
        super(data);
    }

    public String name() {
        return parse(fetch("team.name"));
    }

    public String creature() {
        return fetch("team.creature");
    }

    public String state() {
        return call("address.state");
    }

    public String sport() {
        return fetch("team.sport");
    }
}
