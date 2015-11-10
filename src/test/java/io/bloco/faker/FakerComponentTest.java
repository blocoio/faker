package io.bloco.faker;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.bloco.faker.helpers.RegularExpressionMatcher.matchesPattern;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

public class FakerComponentTest {
    @Test
    public void testSample() throws Exception {
        List<String> options = Arrays.asList("John", "Mary");
        Map<String, Object> data = new HashMap<>();
        data.put("list", options);
        FakerComponent component = new FakerComponent(data);

        assertThat(options, hasItem(component.sample("list")));
    }

    @Test
    public void testNumerify() throws Exception {
        FakerComponent component = new FakerComponent(null);

        String digit = "#";
        assertThat(component.numerify(digit), matchesPattern("\\d"));

        String number = "###";
        assertThat(component.numerify(number), matchesPattern("\\d{3}"));

        String phone = "###-00-####";
        assertThat(component.numerify(phone), matchesPattern("\\d{3}-00-\\d{4}"));

        String version = "#.#.#";
        assertThat(component.numerify(version), matchesPattern("\\d.\\d.\\d"));
    }
}
