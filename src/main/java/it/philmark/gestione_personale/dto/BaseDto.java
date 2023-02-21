package it.philmark.gestione_personale.dto;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor
public abstract class BaseDto {

    private Long creationUser;
    private LocalDateTime creationDate;
    private Long editUser;
    private LocalDateTime editDate;
}
