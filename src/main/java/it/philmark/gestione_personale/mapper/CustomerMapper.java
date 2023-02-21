package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.CustomerDto;
import it.philmark.gestione_personale.model.Customer;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
@NoArgsConstructor
public class CustomerMapper implements Mapper<Customer, CustomerDto> {
    @Override
    public Customer mapDtoToEntityImpl(CustomerDto dto) throws RuntimeException {

        return Customer.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .name(dto.getName())
                .info(dto.getInfo())
                .build();

    }

    @Override
    public CustomerDto mapEntityToDtoImpl(Customer entity) {
        return CustomerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .info(entity.getInfo())
                .build();
    }
}
