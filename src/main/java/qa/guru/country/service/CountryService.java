package qa.guru.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qa.guru.country.data.CountryEntity;
import qa.guru.country.domain.graphql.CountryGql;
import qa.guru.country.domain.graphql.CountryInputGql;
import qa.guru.country.exception.CountryNotFoundException;
import qa.guru.country.model.Country;
import qa.guru.country.data.CountryRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll()
                .stream()
                .map(Country::fromEntity)
                .toList();
    }

    public Country addCountry(Country country) {
        CountryEntity countryEntity = CountryEntity.builder()
                .countryCode(country.countryCode())
                .countryName(country.countryName())
                .build();

        countryRepository.save(countryEntity);
        return country;
    }

    public Country updateCountry(UUID uuid, Country country) {
        CountryEntity countryEntity = countryRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));

        countryEntity = CountryEntity.builder()
                .id(uuid)
                .countryCode(country.countryCode())
                .countryName(country.countryName())
                .build();

        countryRepository.save(countryEntity);
        return Country.fromEntity(countryEntity);
    }

    public CountryGql addCountryGql(CountryInputGql input) {
        CountryEntity countryEntity = CountryEntity.builder()
                .countryCode(input.countryCode())
                .countryName(input.countryName())
                .build();

        countryRepository.save(countryEntity);
        return CountryGql.fromEntity(countryEntity);
    }

    public CountryGql updateCountryGql(UUID uuid, CountryInputGql input) {
        CountryEntity countryEntity = countryRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Country not found"));

        countryEntity = CountryEntity.builder()
                .id(uuid)
                .countryCode(input.countryCode())
                .countryName(input.countryName())
                .build();

        countryRepository.save(countryEntity);
        return CountryGql.fromEntity(countryEntity);
    }

    public List<CountryGql> getAllCountriesGql() {
        return countryRepository.findAll()
                .stream()
                .map(CountryGql::fromEntity)
                .toList();
    }

    public CountryGql getCountryByIdGql(UUID id) {
        CountryEntity countryEntity = countryRepository.findById(id).orElseThrow(() ->
                new CountryNotFoundException(String.format("Country not found with id: %s", id)));
        return CountryGql.fromEntity(countryEntity);
    }
}
