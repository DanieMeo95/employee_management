package it.philmark.gestione_personale.controller;

import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.ResourceDto;
import it.philmark.gestione_personale.dto.TaskDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable("id") String id) throws EmployeeManagementException {
        return ResponseEntity.ok().body(taskService.findById(Long.parseLong(id)));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<TaskDto>> listAll() throws EmployeeManagementException {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.findAll());
    }

    @PostMapping("/insert")
    public ResponseEntity<MessageDto>nuovoIndirizzo(@RequestBody TaskDto taskDto,
                                                    BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) throw new EmployeeManagementException(bindingResult.getAllErrors().stream()
                .map(error->error.getDefaultMessage()).reduce("",(str1,str2)->str1+ " " +str2));
        return ResponseEntity.ok().body(taskService.insert(taskDto));
    }
}
