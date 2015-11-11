package io.bloco.faker;

import java.util.HashMap;
import java.util.Map;

import io.bloco.faker.components.Address;
import io.bloco.faker.components.App;
import io.bloco.faker.components.Company;
import io.bloco.faker.components.Name;

public class FakerData {

    private final Map<String, Object> data;
    private final Map<String, FakerComponent> components;

    public FakerData(Map<String, Object> data) {
        this.data = data;

        // Load components
        FakerComponent[] componentsList = new FakerComponent[]{
                new Address(this),
                new App(this),
                new Company(this),
                new Name(this)
        };

        components = new HashMap<>(componentsList.length);

        for (int i = 0; i < componentsList.length; i++) {
            FakerComponent component = componentsList[i];
            components.put(component.getKey(), component);
        }
    }

    public <K extends FakerComponent> K getComponent(Class<K> componentClass) {
        String componentKey = componentClass.getSimpleName();
        return (K) getComponentByKey(componentKey);
    }

    public FakerComponent getComponentByKey(String componentKey) {
        FakerComponent component = components.get(componentKey.toLowerCase());

        if (component == null) {
            throw new IllegalArgumentException("Unsupported component '" + componentKey + "'");
        }

        return component;
    }

    public Map<String, Object> getComponentData(String componentKey) {
        return (Map<String, Object>) data.get(componentKey);
    }
}
