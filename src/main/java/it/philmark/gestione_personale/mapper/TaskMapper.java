package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.TaskDto;
import it.philmark.gestione_personale.model.Task;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
@NoArgsConstructor
public class TaskMapper implements Mapper<Task, TaskDto> {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Task mapDtoToEntityImpl(TaskDto dto) throws RuntimeException {

        return Task.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .description(dto.getDescription())
                .factory(dto.getFactory())
                .customer(customerMapper.mapDtoToEntityImpl(dto.getCustomerDto()))
                .build();

    }

    @Override
    public TaskDto mapEntityToDtoImpl(Task entity) {
        return TaskDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .factory(entity.getFactory())
                .customerDto(customerMapper.mapEntityToDto(entity.getCustomer()))
                .build();
    }
}