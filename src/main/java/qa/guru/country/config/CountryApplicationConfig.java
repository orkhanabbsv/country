package qa.guru.country.config;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import qa.guru.country.service.DateSerializer;

import java.util.Date;

public class CountryApplicationConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("", Version.unknownVersion());
        module.addSerializer(Date.class, new DateSerializer("dd.MM.yyyy"));
        mapper.registerModule(module);
        return mapper;
    }
}
