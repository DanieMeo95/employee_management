package it.philmark.gestione_personale.controller;

import it.philmark.gestione_personale.dto.CustomerDto;
import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.SkillDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable("id") String id) throws EmployeeManagementException {
        return ResponseEntity.ok().body(customerService.findById(Long.parseLong(id)));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<CustomerDto>> listAll() throws EmployeeManagementException {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll());
    }

    @PostMapping("/insert")
    public ResponseEntity<MessageDto> insert(@RequestBody CustomerDto customerDto,
                                                     BindingResult bindingResult) throws EmployeeManagementException {

        if (bindingResult.hasErrors()) throw new EmployeeManagementException(bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).reduce("", (str1, str2) -> str1 + " " + str2));
        return ResponseEntity.ok().body(customerService.insert(customerDto));
    }

    @PostMapping("/edit")
    public ResponseEntity<MessageDto> edit(@RequestBody CustomerDto customerDto,
                                                     BindingResult bindingResult) throws EmployeeManagementException {

        if (bindingResult.hasErrors()) throw new EmployeeManagementException(bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).reduce("", (str1, str2) -> str1 + " " + str2));
        return ResponseEntity.ok().body(customerService.edit(customerDto));
    }
}
