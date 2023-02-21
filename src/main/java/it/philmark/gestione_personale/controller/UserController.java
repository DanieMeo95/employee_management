package it.philmark.gestione_personale.controller;

import it.philmark.gestione_personale.dto.ResourceDto;
import it.philmark.gestione_personale.dto.UserDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") String id) throws EmployeeManagementException {
        return ResponseEntity.ok().body(userService.findById(Long.parseLong(id)));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<UserDto>> listAll() throws EmployeeManagementException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }
}
