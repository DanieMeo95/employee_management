package it.philmark.gestione_personale.service;

import it.philmark.gestione_personale.dto.CustomerDto;
import it.philmark.gestione_personale.dto.MessageDto;

import java.util.List;

public interface CustomerService {

    public CustomerDto findById(Long id);

    public List<CustomerDto> findAll();

    public MessageDto insert(CustomerDto customerDto);

    public MessageDto edit(CustomerDto customerDto);
}
