package it.philmark.gestione_personale.service.serviceImpl;

import it.philmark.gestione_personale.dto.CustomerDto;
import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.SkillDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.exception.Messages;
import it.philmark.gestione_personale.mapper.CustomerMapper;
import it.philmark.gestione_personale.model.Customer;
import it.philmark.gestione_personale.repository.CustomerRepository;
import it.philmark.gestione_personale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerDto findById(Long id) {
        return customerMapper.mapEntityToDto(
                customerRepository.findById(id).orElseThrow(() -> new EmployeeManagementException(Messages.erroreGenerico)));
    }

    @Override
    public List<CustomerDto> findAll() {
        return customerMapper.mapEntityToDto(customerRepository.findAll());
    }

    @Override
    public MessageDto insert(CustomerDto customerDto) {
        Customer customer = customerMapper.mapDtoToEntity(customerDto);
        customerRepository.save(customer);
        return new MessageDto(Messages.successInsert, HttpStatus.OK);
    }

    @Override
    public MessageDto edit(CustomerDto customerDto) {
        customerRepository.save(customerMapper.mapDtoToEntity(customerDto));
        return new MessageDto(Messages.successEdit, HttpStatus.OK);
    }
}
