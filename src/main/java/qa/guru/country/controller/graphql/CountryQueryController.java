package qa.guru.country.controller.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import qa.guru.country.domain.graphql.CountryGql;
import qa.guru.country.service.CountryService;

import java.util.List;
import java.util.UUID;

@Controller
public class CountryQueryController {

    private final CountryService countryService;

    @Autowired
    public CountryQueryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @QueryMapping
    public List<CountryGql> countries() {
        return countryService.getAllCountriesGql();
    }

    @QueryMapping
    public CountryGql country(@Argument UUID id) {
        return countryService.getCountryByIdGql(id);
    }
}
