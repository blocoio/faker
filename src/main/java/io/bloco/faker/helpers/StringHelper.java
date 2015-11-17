package io.bloco.faker.helpers;

import java.text.Normalizer;
import java.util.List;
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

    public String camelToSnake(String input) {
        return replaceMethod(input, "(?<=\\w)(\\p{Upper})", new StringReplacer() {
            @Override
            public String replaceWith(Matcher matcher) {
                return "_" + matcher.group(1);
            }
        }).toLowerCase();
    }

    public String join(List<String> list, String separator) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String item : list) {
            if (first)
                first = false;
            else
                sb.append(separator);
            sb.append(item);
        }
        return sb.toString();
    }

    public String normalize(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD); // Separate glyphs
        normalized = normalized.replaceAll("[^\\p{ASCII}]", ""); // Remove glyphs
        normalized = normalized.replaceAll("\\W", ""); // Remove anything but letters and numbers
        return normalized.toLowerCase();
    }
}
