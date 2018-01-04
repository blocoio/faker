package io.bloco.faker;

import java.util.HashMap;
import java.util.Map;

import io.bloco.faker.components.Address;
import io.bloco.faker.components.App;
import io.bloco.faker.components.Avatar;
import io.bloco.faker.components.Book;
import io.bloco.faker.components.Bool;
import io.bloco.faker.components.Business;
import io.bloco.faker.components.Color;
import io.bloco.faker.components.Commerce;
import io.bloco.faker.components.Company;
import io.bloco.faker.components.Date;
import io.bloco.faker.components.Food;
import io.bloco.faker.components.Internet;
import io.bloco.faker.components.Lorem;
import io.bloco.faker.components.Name;
import io.bloco.faker.components.Number;
import io.bloco.faker.components.PhoneNumber;
import io.bloco.faker.components.Placeholdit;
import io.bloco.faker.components.SlackEmoji;
import io.bloco.faker.components.Team;
import io.bloco.faker.components.Time;
import io.bloco.faker.components.University;
import io.bloco.faker.helpers.StringHelper;

public class FakerData {

    private final Map<String, Object> data;
    private final Map<String, FakerComponent> components;
    private final StringHelper stringHelper;

    public FakerData(Map<String, Object> data) {
        this.data = data;

        // Load components
        FakerComponent[] componentsList = new FakerComponent[]{
                new Address(this),
                new App(this),
                new Avatar(this),
                new Book(this),
                new Bool(this),
                new Business(this),
                new Color(this),
                new Commerce(this),
                new Company(this),
                new Date(this),
                new Food(this),
                new Internet(this),
                new Lorem(this),
                new Name(this),
                new Number(this),
                new Placeholdit(this),
                new PhoneNumber(this),
                new SlackEmoji(this),
                new Team(this),
                new Time(this),
                new University(this),
        };

        this.components = new HashMap<>(componentsList.length);

        for (FakerComponent component : componentsList) {
            this.components.put(component.getKey(), component);
        }

        this.stringHelper = new StringHelper();
    }

    public <K extends FakerComponent> K getComponent(Class<K> componentClass) {
        String componentKey = componentClass.getSimpleName();
        return (K) getComponentByKey(componentKey);
    }

    public FakerComponent getComponentByKey(String componentKey) {
        String componentKeyInSnake = stringHelper.camelToSnake(componentKey);
        FakerComponent component = components.get(componentKeyInSnake);

        if (component == null) {
            throw new IllegalArgumentException("Unsupported component '" + componentKey + "'");
        }

        return component;
    }

    public Map<String, Object> getComponentData(String componentKey) {
        Map<String, Object> component = (Map<String, Object>) get(componentKey);
        if (component == null) {
            throw new IllegalArgumentException("Unsupported component '" + componentKey + "'");
        }
        return component;
    }

    public Object get(String componentKey) {
        return data.get(componentKey);
    }
}
