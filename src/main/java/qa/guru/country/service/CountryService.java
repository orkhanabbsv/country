package qa.guru.country.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qa.guru.country.data.CountryEntity;
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
}
