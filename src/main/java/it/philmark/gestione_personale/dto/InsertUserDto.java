package it.philmark.gestione_personale.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class InsertUserDto extends BaseDto{
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
