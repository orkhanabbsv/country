package qa.guru.country.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qa.guru.country.model.Country;
import qa.guru.country.service.CountryService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/")
    public List<Country> getAll() {
        return countryService.getAllCountries();
    }

    @PostMapping("/add")
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PatchMapping("/update/{uuid}")
    public Country updateCountry(@PathVariable UUID uuid, @RequestBody Country country) {
        return countryService.updateCountry(uuid ,country);
    }
}
