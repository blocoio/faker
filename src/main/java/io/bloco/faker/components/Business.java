package io.bloco.faker.components;

import org.joda.time.DateTime;

import java.util.Date;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Business extends FakerComponent {

    private static final int CREDIT_CARD_PLUS_YEARS_MAX = 4;

    public Business(FakerData data) {
        super(data);
    }

    public String creditCardNumber() {
        return fetch("business.credit_card_numbers");
    }

    public Date creditCardExpireDate() {
        return DateTime.now()
                .plusYears(randomHelper.number(CREDIT_CARD_PLUS_YEARS_MAX) + 1)
                .toDate();
    }

    public String creditCardType() {
        return fetch("business.credit_card_types");
    }
}
