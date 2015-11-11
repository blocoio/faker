package io.bloco.faker.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    public interface StringReplacer {
        String replaceWith(Matcher matcher);
    }

    public String replaceMethod(String input, String regex, StringReplacer replacer) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String replacement = replacer.replaceWith(matcher);
            matcher.appendReplacement(stringBuffer, replacement);
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public String snakeToCamel(String input) {
        return replaceMethod(input, "_(\\p{Lower})", new StringReplacer() {
            @Override
            public String replaceWith(Matcher matcher) {
                String letter = matcher.group(1);
                return letter.toUpperCase();
            }
        });
    }
}
