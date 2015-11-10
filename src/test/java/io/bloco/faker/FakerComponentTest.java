package io.bloco.faker;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.bloco.faker.helpers.RegularExpressionMatcher.matchesPattern;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FakerComponentTest {

    public class TestComponent extends FakerComponent {
        public TestComponent(FakerData data) {
            super(data);
        }

        public String test() {
            return "test";
        }
    }

    private FakerData fakerData;
    private FakerComponent fakerComponent;

    @Before
    public void setUp() throws Exception {
        fakerData = mock(FakerData.class);
        fakerComponent = new TestComponent(fakerData);
    }

    @Test
    public void testSample() throws Exception {
        List<String> options = Arrays.asList("John", "Mary");
        Map<String, Object> data = new HashMap<>();
        data.put("list", options);
        when(fakerData.getComponentData(anyString())).thenReturn(data);

        assertThat(options, hasItem(fakerComponent.sample("list")));
    }

    @Test
    public void testSampleNestedLists() throws Exception {
        List<String> options = Arrays.asList("John", "Mary");
        Map<String, Object> data = new HashMap<>();
        data.put("list", Arrays.asList(options, options));
        when(fakerData.getComponentData(anyString())).thenReturn(data);

        assertThat(options, hasItem(fakerComponent.sample("list")));
    }

    @Test
    public void testNumerify() throws Exception {
        String digit = "#";
        assertThat(fakerComponent.numerify(digit), matchesPattern("\\d"));

        String number = "###";
        assertThat(fakerComponent.numerify(number), matchesPattern("\\d{3}"));

        String phone = "###-00-####";
        assertThat(fakerComponent.numerify(phone), matchesPattern("\\d{3}-00-\\d{4}"));

        String version = "#.#.#";
        assertThat(fakerComponent.numerify(version), matchesPattern("\\d.\\d.\\d"));
    }

    @Test
    public void testParse() throws Exception {
        when(fakerData.getComponentByKey(anyString())).thenReturn(fakerComponent);

        assertThat(fakerComponent.parse("#{test}"), is(equalTo("test")));
        assertThat(fakerComponent.parse("#{testcomponent.test}"), is(equalTo("test")));
        assertThat(fakerComponent.parse("#{TestComponent.test}"), is(equalTo("test")));
        assertThat(fakerComponent.parse("#{TestComponent.test} - #{TestComponent.test}"),
                is(equalTo("test - test")));
    }

    // Helpers

    private Map<String, Object> newComponentData(String componentKey,
                                                 Map<String, Object> internalData) {
        Map<String, Object> data = new HashMap<>();
        data.put(componentKey, internalData);
        return data;
    }
}
