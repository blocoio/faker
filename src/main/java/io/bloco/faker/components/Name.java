package io.bloco.faker.components;

import java.util.List;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Name extends FakerComponent {

    public Title title;

    public Name(FakerData data) {
        super(data);
        title = new Title();
    }

    public String first_name() {
        return sample("first_name");
    }

    public String last_name() {
        return sample("last_name");
    }

    public String prefix() {
        return sample("prefix");
    }

    public String suffix() {
        return sample("suffix");
    }

    public String name() {
        return parse(sample("name"));
    }


    public class Title {
        public String descriptor() {
            return sample((List) getMap("title").get("descriptor"));
        }

        public String level() {
            return sample((List) getMap("title").get("level"));
        }

        public String job() {
            return sample((List) getMap("title").get("job"));
        }
    }
}