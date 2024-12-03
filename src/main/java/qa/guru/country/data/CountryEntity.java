package qa.guru.country.data;

import jakarta.persistence.*;
import lombok.*;
import qa.guru.country.model.Country;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@Table(name = "country")
@AllArgsConstructor
@NoArgsConstructor
public class CountryEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue()
    private UUID id;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_code")
    private String countryCode;
}
