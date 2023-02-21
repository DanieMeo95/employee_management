package it.philmark.gestione_personale.service.serviceImpl;

import it.philmark.gestione_personale.dto.ResourceDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.exception.Messages;
import it.philmark.gestione_personale.mapper.ResourceMapper;
import it.philmark.gestione_personale.repository.ResourceRepository;
import it.philmark.gestione_personale.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceMapper resourceMapper;


    @Override
    public ResourceDto findById(Long id) {
        return resourceMapper.mapEntityToDto(resourceRepository.findById(id).orElseThrow(()-> new EmployeeManagementException(Messages.erroreGenerico)));
    }

    @Override
    public List<ResourceDto> findAll() {
        return resourceMapper.mapEntityToDto(resourceRepository.findAll());
    }

    @Override
    public void insert(ResourceDto resourceDto) {
        resourceRepository.save(resourceMapper.mapDtoToEntity(resourceDto));
    }

    @Override
    public void edit(ResourceDto resourceDto) {
        resourceRepository.save(resourceMapper.mapDtoToEntity(resourceDto));
    }
}
