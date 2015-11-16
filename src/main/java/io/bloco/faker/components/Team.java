package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Team extends FakerComponent {

    public Team(FakerData data) {
        super(data);
    }

    public String name() {
        return parse(sample("name"));
    }

    public String creature() {
        return sample("creature");
    }

    public String state() {
        return getTopLevel("address.state");
    }

    public String sport() {
        return sample("sport");
    }
}
