package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Bool extends FakerComponent {

    public Bool(FakerData data) {
        super(data);
    }

    public boolean bool() {
        return bool(0.5f);
    }

    public boolean bool(float trueRatio) {
        return Math.random() < trueRatio;
    }
}
