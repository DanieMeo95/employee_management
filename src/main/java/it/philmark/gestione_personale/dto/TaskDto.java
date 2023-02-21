package it.philmark.gestione_personale.dto;

import it.philmark.gestione_personale.model.Customer;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class TaskDto extends BaseDto {
    @Nullable
    private Long id;
    private String description;
    private Boolean factory;
    private CustomerDto customerDto;
}
