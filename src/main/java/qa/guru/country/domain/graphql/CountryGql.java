package qa.guru.country.domain.graphql;

import qa.guru.country.data.CountryEntity;

import java.util.Date;
import java.util.UUID;

public record CountryGql(
        UUID id,
        String countryName,
        String countryCode,
        Date independenceDay
) {
    public static CountryGql fromEntity(CountryEntity ce) {
        return new CountryGql(
                ce.getId(),
                ce.getCountryName(),
                ce.getCountryCode(),
                new Date()
        );
    }
}
