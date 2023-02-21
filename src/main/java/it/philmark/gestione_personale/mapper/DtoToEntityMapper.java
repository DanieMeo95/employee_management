package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.BaseDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public interface DtoToEntityMapper<E extends BaseEntity, D extends BaseDto>  {


    E mapDtoToEntityImpl(D dto) throws RuntimeException;

    default E mapDtoToEntity(D dto) throws EmployeeManagementException {
        if (dto == null) return null;
        E entity;
        try { entity = mapDtoToEntityImpl(dto);
        } catch (RuntimeException ex) { throw new EmployeeManagementException(ex); }
        return entity;
    }

    default List<E> mapDtoToEntity(List<D> dtos) throws EmployeeManagementException {
        if (dtos == null) return null;
        List<E> entities = new ArrayList<>();
        for (D dto : dtos) entities.add(mapDtoToEntity(dto));
        return entities;
    }

}
