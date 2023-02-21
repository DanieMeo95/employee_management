package it.philmark.gestione_personale.controller;

import it.philmark.gestione_personale.dto.ResourceDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDto> findById(@PathVariable("id") String id) throws EmployeeManagementException {
        return ResponseEntity.ok().body(resourceService.findById(Long.parseLong(id)));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<ResourceDto>> listAll() throws EmployeeManagementException {
        return ResponseEntity.status(HttpStatus.OK).body(resourceService.findAll());
    }
}
