package io.bloco.faker;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import io.bloco.faker.components.Address;
import io.bloco.faker.components.App;
import io.bloco.faker.components.Avatar;
import io.bloco.faker.components.Book;
import io.bloco.faker.components.Business;
import io.bloco.faker.components.Color;
import io.bloco.faker.components.Commerce;
import io.bloco.faker.components.Company;
import io.bloco.faker.components.Date;
import io.bloco.faker.components.Name;
import io.bloco.faker.components.Team;
import io.bloco.faker.components.Time;
import io.bloco.faker.components.University;
import io.bloco.faker.helpers.MapHelper;

public class Faker {

    public static final String DEFAULT_LOCALE = "en";

    public final Address address;
    public final App app;
    public final Avatar avatar;
    public final Book book;
    public final Business business;
    public final Color color;
    public final Commerce commerce;
    public final Company company;
    public final Date date;
    public final Name name;
    public final Team team;
    public final Time time;
    public final University university;

    private final String locale;
    private final FakerData data;

    public Faker() {
        this(DEFAULT_LOCALE);
    }

    public Faker(String locale) {
        this.locale = locale;

        // Load data
        MapHelper mapHelper = new MapHelper();
        Map<String, Object> data = loadData(DEFAULT_LOCALE); // Fallbacks first
        if (!this.locale.equals(DEFAULT_LOCALE)) {
            mapHelper.deepMerge(data, loadData(this.locale));
        }
        this.data = new FakerData(data);

        // Load components
        this.address = this.data.getComponent(Address.class);
        this.app = this.data.getComponent(App.class);
        this.avatar = this.data.getComponent(Avatar.class);
        this.book = this.data.getComponent(Book.class);
        this.business = this.data.getComponent(Business.class);
        this.color = this.data.getComponent(Color.class);
        this.commerce = this.data.getComponent(Commerce.class);
        this.company = this.data.getComponent(Company.class);
        this.date = this.data.getComponent(Date.class);
        this.name = this.data.getComponent(Name.class);
        this.team = this.data.getComponent(Team.class);
        this.time = this.data.getComponent(Time.class);
        this.university = this.data.getComponent(University.class);
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
