package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.ResourceDto;
import it.philmark.gestione_personale.model.Resource;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class ResourceMapper implements Mapper<Resource, ResourceDto> {


    @Override
    public Resource mapDtoToEntityImpl(ResourceDto dto) throws RuntimeException {

        return Resource.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .name(dto.getName())
                .surname(dto.getSurname())
                .dateBirth(dto.getDateBirth())
                .city(dto.getCity())
                .email(dto.getEmail())
                .internal(dto.getInternal())
                .build();

    }

    @Override
    public ResourceDto mapEntityToDtoImpl(Resource entity) {
        return ResourceDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .dateBirth(entity.getDateBirth())
                .city(entity.getCity())
                .email(entity.getEmail())
                .internal(entity.getInternal())
                .build();
    }
}