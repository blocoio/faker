package io.bloco.faker;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import io.bloco.faker.helpers.RandomHelper;
import io.bloco.faker.helpers.StringHelper;

public abstract class FakerComponent {

    private static final String DIGIT_SYMBOL = "#";
    private static final String PARSE_REGEXP = "\\#\\{(.+?)\\}";

    private final FakerData data;
    private final RandomHelper randomHelper;
    private final StringHelper stringHelper;

    public FakerComponent(FakerData data) {
        this.data = data;
        this.randomHelper = new RandomHelper();
        this.stringHelper = new StringHelper();
    }

    public String getKey() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    protected String sample(String listKey) {
        return sample(getList(listKey));
    }

    protected String sample(List options) {
        Object option = randomHelper.sample(options);

        if (option instanceof String) {
            return (String) option;
        } else if (option instanceof List) {
            // List of lists
            return (String) randomHelper.sample((List) option);
        } else {
            throw new UnsupportedOperationException("Unsupported data type");
        }
    }

    protected String numerify(String input) {
        return stringHelper.replaceMethod(input, DIGIT_SYMBOL, new StringHelper.StringReplacer() {
            @Override
            public String replaceWith(Matcher matcher) {
                return randomHelper.digit();
            }
        });
    }

    protected String parse(String input) {
        return stringHelper.replaceMethod(input, PARSE_REGEXP, new StringHelper.StringReplacer() {
            @Override
            public String replaceWith(Matcher matcher) {
                String key = matcher.group(1);
                return getParsedValue(key);
            }
        });
    }

    protected List getList(String listKey) {
        List list = (List) data.getComponentData(getKey()).get(listKey);
        if (list == null) {
            throw new UnsupportedOperationException("Unsupported method '" + listKey + "'");
        }
        return list;
    }

    protected Map<String, Object> getMap(String listKey) {
        Map<String, Object> map =
                (Map<String, Object>) data.getComponentData(getKey()).get(listKey);
        if (map == null) {
            throw new UnsupportedOperationException("Unsupported method '" + listKey + "'");
        }
        return map;
    }

    private String getParsedValue(String key) {
        if (key.contains(".")) {
            String[] keys = key.split("\\.");
            return data.getComponentByKey(keys[0]).get(keys[1]);
        } else {
            return get(key);
        }
    }

    private String get(String methodKey) {
        String methodKeyCamel = stringHelper.snakeToCamel(methodKey);
        String value;
        try {
            value = (String) getClass().getDeclaredMethod(methodKeyCamel).invoke(this);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            throw new IllegalArgumentException(
                    "Unsupported method '" + methodKey + "' " +
                            "for component '" + this.getKey() + "'", e);
        }
        return value;
    }
}
