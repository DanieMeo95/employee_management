package it.philmark.gestione_personale.dto;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.lang.Nullable;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
public class CustomerDto extends BaseDto {
    @Nullable
    private Long id;
    private String name;
    private String info;

}
