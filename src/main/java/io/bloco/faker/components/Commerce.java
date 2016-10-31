package io.bloco.faker.components;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Commerce extends FakerComponent {

    public Commerce(FakerData data) {
        super(data);
    }

    public String color() {
        return call("color.colorName");
    }

    public String department() {
        return department(3);
    }

    public String department(int max) {
        return department(max, false);
    }

    public String department(int max, boolean fixedAmount) {
        int num;

        if (fixedAmount) {
            num = max;
        } else {
            num = 1 + randomHelper.number(max);
        }

        List<String> categories = getCategories(num);

        if (num > 1) {
            return mergeCategories(categories);
        } else {
            return categories.get(0);
        }
    }

    public String productName() {
        return fetch("commerce.product_name.adjective")
                + " " + fetch("commerce.product_name.material")
                + " " + fetch("commerce.product_name.product");
    }

    public String material() {
        return fetch("commerce.product_name.material");
    }

    public BigDecimal price() {
        return price(0, 100);
    }

    public BigDecimal price(int min, int max) {
        return new BigDecimal(randomHelper.range(min, max))
                .round(new MathContext(2, RoundingMode.HALF_UP));
    }

    public String promotionCode() {
        return promotionCode(6);
    }

    public String promotionCode(int digits) {
        return fetch("commerce.promotion_code.adjective")
                + fetch("commerce.promotion_code.noun")
                + getComponent(Number.class).number(digits);
    }

    // Helpers

    private List<String> getCategories(int num) {
        List<String> categories = new ArrayList<>(num);

        while (categories.size() != num) {
            String category = fetch("commerce.department");
            if (!categories.contains(category)) {
                categories.add(category);
            }
        }

        return categories;
    }

    private String mergeCategories(List<String> categories) {
        List<String> commaCategories = categories.subList(0, categories.size() - 1);
        String commaSeparated = stringHelper.join(commaCategories, ", ");
        return commaSeparated + getSeparator() + categories.get(categories.size() - 1);
    }
}
