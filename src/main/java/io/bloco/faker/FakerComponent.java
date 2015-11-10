package io.bloco.faker;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakerComponent {

    private static final String DIGIT_SYMBOL = "#";

    protected final Map<String, Object> data;
    protected final Random random;

    public FakerComponent(Map<String, Object> data) {
        this.data = data;
        this.random = new Random();
    }

    // Return random item from list
    protected String sample(String listKey) {
        List<String> options = (List<String>) data.get(listKey);
        return options.get(random.nextInt(options.size()));
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
}
