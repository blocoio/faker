package io.bloco.faker;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import io.bloco.faker.components.Address;
import io.bloco.faker.components.App;
import io.bloco.faker.components.Company;
import io.bloco.faker.components.Name;

public class Faker {

    public static final String DEFAULT_LOCALE = "en";

    public final Address address;
    public final App app;
    public final Company company;
    public final Name name;

    private final String locale;
    private final FakerData data;

    public Faker() {
        this(DEFAULT_LOCALE);
    }

    public Faker(String locale) {
        this.locale = locale;
        this.data = new FakerData(loadData(this.locale));

        // Load components
        this.address = this.data.getComponent(Address.class);
        this.app = this.data.getComponent(App.class);
        this.company = this.data.getComponent(Company.class);
        this.name = this.data.getComponent(Name.class);
    }

    public String getLocale() {
        return locale;
    }

    private Map<String, Object> loadData(String locale) {
        Yaml yaml = new Yaml();
        InputStream input = null;
        try {
            input = new FileInputStream(getDataFile(locale));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> root = (Map<String, Object>) yaml.load(input);
        Map<String, Object> fakerData = (Map<String, Object>) root.values().iterator().next();
        return (Map<String, Object>) fakerData.values().iterator().next();
    }

    private File getDataFile(String locale) {
        File file = new File("locales/" + locale + ".yml");
        if (!file.exists()) {
            throw new IllegalArgumentException("Unavailable locale '" + locale + "'");
        }
        return file;
    }
}
