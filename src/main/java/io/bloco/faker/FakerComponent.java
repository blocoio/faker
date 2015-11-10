package io.bloco.faker;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class FakerComponent {

    private static final String DIGIT_SYMBOL = "#";
    private static final String PARSE_REGEXP = "\\#\\{(.+?)\\}";

    private final FakerData data;
    private final Random random;

    public FakerComponent(FakerData data) {
        this.data = data;
        this.random = new Random();
    }

    public String getKey() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    protected String sample(String listKey) {
        return sample(getList(listKey));
    }

    protected String sample(List options) {
        Object option = getSampleObjectFromList(options);

        if (option instanceof String) {
            return (String) option;
        } else if (option instanceof List) {
            // List of lists
            return (String) getSampleObjectFromList((List) option);
        } else {
            throw new UnsupportedOperationException("Unsupported data type");
        }
    }

    protected String numerify(String input) {
        Pattern pattern = Pattern.compile(DIGIT_SYMBOL);
        Matcher matcher = pattern.matcher(input);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String digit = Integer.toString(random.nextInt(10));
            matcher.appendReplacement(stringBuffer, digit);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    protected String parse(String input) {
        Pattern pattern = Pattern.compile(PARSE_REGEXP);
        Matcher matcher = pattern.matcher(input);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String key = matcher.group(1);
            String value = getParsedValue(key);
            matcher.appendReplacement(stringBuffer, value);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
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
        String value;
        try {
            value = (String) getClass().getDeclaredMethod(methodKey).invoke(this);
        } catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException e) {
            throw new IllegalArgumentException(
                    "Unsupported method '" + methodKey + "' " +
                            "for component '" + this.getKey() + "'", e);
        }
        return value;
    }

    private Object getSampleObjectFromList(List options) {
        return options.get(random.nextInt(options.size()));
    }
}
