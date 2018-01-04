package io.bloco.faker;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
import io.bloco.faker.helpers.MapHelper;

public class Faker {

    public static final String DEFAULT_LOCALE = "en";

    public final Address address;
    public final App app;
    public final Avatar avatar;
    public final Book book;
    public final Bool bool;
    public final Business business;
    public final Color color;
    public final Commerce commerce;
    public final Company company;
    public final Date date;
    public final Food food;
    public final Internet internet;
    public final Lorem lorem;
    public final Name name;
    public final Number number;
    public final Placeholdit placeholdit;
    public final PhoneNumber phoneNumber;
    public final SlackEmoji slackEmoji;
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
        Map<String, Object> data = loadData(DEFAULT_LOCALE); // Fallbacks first
        if (!this.locale.equals(DEFAULT_LOCALE)) {
            MapHelper.deepMerge(data, loadData(this.locale));
        }
        this.data = new FakerData(data);

        // Load components
        this.address = this.data.getComponent(Address.class);
        this.app = this.data.getComponent(App.class);
        this.avatar = this.data.getComponent(Avatar.class);
        this.book = this.data.getComponent(Book.class);
        this.bool = this.data.getComponent(Bool.class);
        this.business = this.data.getComponent(Business.class);
        this.color = this.data.getComponent(Color.class);
        this.commerce = this.data.getComponent(Commerce.class);
        this.company = this.data.getComponent(Company.class);
        this.date = this.data.getComponent(Date.class);
        this.food = this.data.getComponent(Food.class);
        this.internet = this.data.getComponent(Internet.class);
        this.lorem = this.data.getComponent(Lorem.class);
        this.name = this.data.getComponent(Name.class);
        this.number = this.data.getComponent(Number.class);
        this.placeholdit = this.data.getComponent(Placeholdit.class);
        this.phoneNumber = this.data.getComponent(PhoneNumber.class);
        this.slackEmoji = this.data.getComponent(SlackEmoji.class);
        this.team = this.data.getComponent(Team.class);
        this.time = this.data.getComponent(Time.class);
        this.university = this.data.getComponent(University.class);
    }

    public String getLocale() {
        return locale;
    }

    private Map<String, Object> loadData(String locale) {
        List<File> localeFiles = getLocaleFiles(locale);
        Map<String, Object> fullData = new HashMap<>();
        for (File localeFile : localeFiles) {
            MapHelper.deepMerge(fullData, getDataFromLocaleFile(localeFile));
        }
        return fullData;
    }

    private List<File> getLocaleFiles(String locale) {
        ClassLoader classLoader = getClass().getClassLoader();

        URL baseResource = classLoader.getResource("locales/" + locale + ".yml");
        if (baseResource == null) {
            throw new IllegalArgumentException("Unavailable locale \'" + locale + "\'");
        }

        List<File> files = new ArrayList<>();
        files.add(new File(baseResource.getPath()));

        URL folderResource = classLoader.getResource("locales/" + locale);
        if (folderResource != null) {
            File[] folderFiles = new File(folderResource.getPath()).listFiles();
            if (folderFiles != null) {
                files.addAll(Arrays.asList(folderFiles));
            }
        }

        return files;
    }

    private Map<String, Object> getDataFromLocaleFile(File file) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }

        Yaml yaml = new Yaml();
        Map<String, Object> root = (Map<String, Object>) yaml.load(fileInputStream);
        Map<String, Object> fakerData = (Map<String, Object>) root.values().iterator().next();
        return (Map<String, Object>) fakerData.get("faker");
    }

}
