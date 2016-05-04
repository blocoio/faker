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
    protected final RandomHelper randomHelper;
    protected final StringHelper stringHelper;

    public FakerComponent(FakerData data) {
        this.data = data;
        this.randomHelper = new RandomHelper();
        this.stringHelper = new StringHelper();
    }

    public String getKey() {
        return stringHelper.camelToSnake(this.getClass().getSimpleName());
    }

    protected String fetch(String key) {
        String[] keys = key.split("\\.");

        List list;
        if (keys.length == 2) {
            list = getList(keys[0], keys[1]);
        } else {
            list = (List) getMap(keys[0], keys[1]).get(keys[2]);
        }

        return sampleFromList(list);
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
                return call(key);
            }
        });
    }

    protected String call(String key) {
        if (key.contains(".")) {
            String[] keys = key.split("\\.");
            return data.getComponentByKey(keys[0]).callMethod(keys[1]);
        } else {
            return callMethod(key);
        }
    }

    protected String getSeparator() {
        return (String) data.get("separator");
    }

    protected String sampleFromList(List options) {
        Object option = randomHelper.sample(options);

        if (option instanceof String) {
            return (String) option;
        } else if (option instanceof List) { // List of lists
            return (String) randomHelper.sample((List) option);
        } else {
            throw new UnsupportedOperationException("Unsupported data type");
        }
    }

    protected List getList(String componentKey, String listKey) {
        List list = (List) getComponentData(componentKey).get(listKey);
        if (list == null) {
            throw new UnsupportedOperationException("Unsupported method '" + listKey + "'");
        }
        return list;
    }

    protected <K extends FakerComponent> K getComponent(Class<K> klass) {
        try {
            return klass.getConstructor(FakerData.class).newInstance(data);
        } catch (InstantiationException|NoSuchMethodException|
                IllegalAccessException|InvocationTargetException e) {
            throw new IllegalArgumentException("Unsupported component '" + klass + "'", e);
        }
    }

    private String callMethod(String methodKey) {
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

    protected Map<String, Object> getMap(String componentKey, String listKey) {
        Map<String, Object> map = (Map<String, Object>) getComponentData(componentKey).get(listKey);
        if (map == null) {
            throw new UnsupportedOperationException("Unsupported method '" + listKey + "'");
        }
        return map;
    }

    private Map<String, Object> getComponentData(String componentKey) {
        return data.getComponentData(componentKey);
    }
}
