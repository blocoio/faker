package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;

public class Address extends FakerComponent {

    public Address(FakerData data) {
        super(data);
    }

    public String cityPrefix() {
        return sample("city_prefix");
    }

    public String citySuffix() {
        return sample("city_suffix");
    }

    public String country() {
        return sample("country");
    }

    public String countryCode() {
        return sample("country_code");
    }

    public String buildingNumber() {
        return numerify(sample("building_number"));
    }

    public String streetSuffix() {
        return sample("street_suffix");
    }

    public String secondaryAddress() {
        return sample("secondary_address");
    }

    public String postcode() {
        return sample("postcode");
    }

    public String postcodeByState() {
        return sample("postcode_by_state");
    }

    public String state() {
        return sample("state");
    }

    public String stateAbbr() {
        return sample("state_abbr");
    }

    public String timeZone() {
        return sample("time_zone");
    }

    public String city() {
        return parse(sample("city"));
    }

    public String streetName() {
        return parse(sample("street_name"));
    }

    public String streetAddress() {
        return parse(sample("street_address"));
    }

    public String defaultCountry() {
        return sample("default_country");
    }
}
