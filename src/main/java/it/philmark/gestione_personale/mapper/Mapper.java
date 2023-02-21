package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.BaseDto;
import it.philmark.gestione_personale.model.BaseEntity;

public interface Mapper<E extends BaseEntity, D extends BaseDto> extends EntityToDtoMapper<E, D>, DtoToEntityMapper<E, D> {

}
