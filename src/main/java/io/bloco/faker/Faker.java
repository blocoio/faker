package io.bloco.faker;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import io.bloco.faker.components.App;

public class Faker {

    public static final String DEFAULT_LOCALE = "en";

    public final App app;

    private final String locale;
    private final Map<String, Object> data;


    public Faker() {
        this.locale = DEFAULT_LOCALE;
        this.data = loadData(this.locale);

        // Load components
        this.app = new App(getComponentData(App.KEY));
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
            throw new RuntimeException("Unavailable locale " + locale);
        }
        return file;
    }

    private Map<String, Object> getComponentData(String componentKey) {
        return (Map<String, Object>) data.get(componentKey);
    }
}
