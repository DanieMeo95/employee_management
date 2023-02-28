package it.philmark.gestione_personale.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

import java.util.Date;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class ResourceDto extends BaseDto {
    @Nullable
    private Long id;
    private String name;
    private String surname;
    private Date dateBirth;
    private String city;
    private String email;
    private Boolean internal;

}
