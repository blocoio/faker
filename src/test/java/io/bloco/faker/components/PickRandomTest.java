package io.bloco.faker.components;

import io.bloco.faker.Faker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PickRandomTest {

    private Faker faker;

    private enum CurrencyEnum {
        KES(1.00), USD(103.31), GBP(138.3373), EUR(121.12), TZS(0.0463858), UGX(0.0300622);

        double rate = 0.00;

        private CurrencyEnum(double r) {
            rate = r;
        }
    }

    @Before
    public void setUp() throws Exception {

        faker = new Faker();
    }

    @Test
    public void fromEnum() throws Exception {

        Enum money = faker.pickRandom.fromEnum(CurrencyEnum.class);

        Collection currencyCollection = Arrays.asList(CurrencyEnum.class.getEnumConstants());

        assertTrue(currencyCollection.contains(money));
    }

    @Test
    public void fromArray() throws Exception {

        String[] workWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        String workDay = faker.pickRandom.fromArray(workWeek);

        Collection workWkColl = Arrays.asList(workWeek);

        assertTrue(workWkColl.contains(workDay));
    }

    @Test
    public void fromVarArgs() throws Exception {

        String[] workWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        String workDay =
                faker.pickRandom.fromVarArgs("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");

        Collection workWkColl = Arrays.asList(workWeek);

        assertTrue(workWkColl.contains(workDay));
    }

    @Test
    public void fromCollection() throws Exception {

        String[] workWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        Collection<String> coll = Arrays.asList(workWeek);

        String workDay =
                faker.pickRandom.fromCollection(coll);

        Collection workWkColl = Arrays.asList(workWeek);

        assertTrue(workWkColl.contains(workDay));
    }
}