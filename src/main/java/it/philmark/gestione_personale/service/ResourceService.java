package it.philmark.gestione_personale.service;

import it.philmark.gestione_personale.dto.ResourceDto;

import java.util.List;

public interface ResourceService {

    public ResourceDto findById(Long id);

    public List<ResourceDto> findAll();

    public void insert(ResourceDto resourceDto);

    public void edit(ResourceDto resourceDto);
}
