package it.philmark.gestione_personale.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
    private String mobile;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String repeatePassword;
}
