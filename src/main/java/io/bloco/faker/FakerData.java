package io.bloco.faker;

import java.util.HashMap;
import java.util.Map;

import io.bloco.faker.components.Address;
import io.bloco.faker.components.App;
import io.bloco.faker.components.Avatar;
import io.bloco.faker.components.Book;
import io.bloco.faker.components.Business;
import io.bloco.faker.components.Color;
import io.bloco.faker.components.Commerce;
import io.bloco.faker.components.Company;
import io.bloco.faker.components.Name;
import io.bloco.faker.components.Time;

public class FakerData {

    private final Map<String, Object> data;
    private final Map<String, FakerComponent> components;

    public FakerData(Map<String, Object> data) {
        this.data = data;

        // Load components
        FakerComponent[] componentsList = new FakerComponent[]{
                new Address(this),
                new App(this),
                new Avatar(this),
                new Book(this),
                new Business(this),
                new Color(this),
                new Commerce(this),
                new Company(this),
                new Name(this),
                new Time(this),
        };

        components = new HashMap<>(componentsList.length);

        for (FakerComponent component : componentsList) {
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
        return (Map<String, Object>) get(componentKey);
    }

    public Object get(String componentKey) {
        return data.get(componentKey);
    }
}
