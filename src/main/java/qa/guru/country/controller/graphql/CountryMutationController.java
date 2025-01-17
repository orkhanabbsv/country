package qa.guru.country.controller.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import qa.guru.country.domain.graphql.CountryGql;
import qa.guru.country.domain.graphql.CountryInputGql;
import qa.guru.country.service.CountryService;

import java.util.UUID;

@Controller
public class CountryMutationController {

    private final CountryService countryService;

    @Autowired
    public CountryMutationController(CountryService countryService) {
        this.countryService = countryService;
    }

    @MutationMapping
    public CountryGql addCountry(@Argument CountryInputGql input) {
        return countryService.addCountryGql(input);
    }

    @MutationMapping
    public CountryGql updateCountry(@Argument UUID id, @Argument CountryInputGql input) {
        return countryService.updateCountryGql(id, input);
    }
}
