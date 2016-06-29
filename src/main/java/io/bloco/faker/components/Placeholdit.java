package io.bloco.faker.components;

import java.util.Arrays;
import java.util.List;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;
import io.bloco.faker.helpers.StringHelper;

public class Placeholdit extends FakerComponent {

    public static final List<String> SUPPORTED_FORMATS = Arrays.asList("png", "jpg", "jpeg", "gif");

    private static final String PLACEHOLDER_URL = "https://placehold.it/";
    private static final String SIZE_REGEX = "^[0-9]+x[0-9]+$";
    private static final String HEX_REGEX =
            "((?:^[0-9a-fA-F]{3}$)|(?:^[0-9a-fA-F]{6}$)){1}(?!.*[^0-9a-fA-F])";

    private final StringHelper stringHelper;

    public Placeholdit(FakerData data) {
        super(data);
        stringHelper = new StringHelper();
    }

    public String image() {
        return image("300x300");
    }

    public String image(String size) {
        return image(size, "png");
    }

    public String image(String size, String format) {
        return image(size, format, null);
    }

    public String image(String size, String format, String backgroundColor) {
        return image(size, format, backgroundColor, null);
    }

    public String image(String size, String format, String backgroundColor, String textColor) {
        return image(size, format, backgroundColor, textColor, null);
    }

    public String image(String size, String format,
                        String backgroundColor, String textColor, String text) {

        if (!size.matches(SIZE_REGEX)) {
            throw new IllegalArgumentException("Size should be specified in format 300x300");
        }

        if (!SUPPORTED_FORMATS.contains(format)) {
            throw new IllegalArgumentException("Supported formats are "
                    + stringHelper.join(SUPPORTED_FORMATS, ","));
        }

        if (backgroundColor != null && !backgroundColor.matches(HEX_REGEX)) {
            throw new IllegalArgumentException("backgroundColor must be a hex value without '#'");
        }

        if (backgroundColor == null && textColor != null) {
            throw new IllegalArgumentException("backgroundColor must be used with the textColor");
        }

        if (textColor != null && !textColor.matches(HEX_REGEX)) {
            throw new IllegalArgumentException("textColor must be a hex value without '#'");
        }

        String imageUrl = PLACEHOLDER_URL + size + "." + format;

        if (backgroundColor != null) {
            imageUrl += "/" + backgroundColor;
        }

        if (textColor != null) {
            imageUrl += "/" + textColor;
        }

        if (text != null) {
            imageUrl += "?text=" + text;
        }

        return imageUrl;
    }
}
