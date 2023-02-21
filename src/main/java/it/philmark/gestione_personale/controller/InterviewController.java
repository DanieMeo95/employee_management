package it.philmark.gestione_personale.controller;

import it.philmark.gestione_personale.dto.CustomerDto;
import it.philmark.gestione_personale.dto.InterviewDto;
import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.service.CustomerService;
import it.philmark.gestione_personale.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/{id}")
    public ResponseEntity<InterviewDto> findById(@PathVariable("id") String id) throws EmployeeManagementException {
        return ResponseEntity.ok().body(interviewService.findById(Long.parseLong(id)));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<InterviewDto>> listAll() throws EmployeeManagementException {
        return ResponseEntity.status(HttpStatus.OK).body(interviewService.findAll());
    }

    @PostMapping("/insert")
    public ResponseEntity<MessageDto> insert(@RequestBody InterviewDto interviewDto,
                                             BindingResult bindingResult) throws EmployeeManagementException {

        if (bindingResult.hasErrors()) throw new EmployeeManagementException(bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).reduce("", (str1, str2) -> str1 + " " + str2));
        return ResponseEntity.ok().body(interviewService.insert(interviewDto));
    }

    @PostMapping("/edit")
    public ResponseEntity<MessageDto> edit(@RequestBody InterviewDto interviewDto,
                                           BindingResult bindingResult) throws EmployeeManagementException {

        if (bindingResult.hasErrors()) throw new EmployeeManagementException(bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).reduce("", (str1, str2) -> str1 + " " + str2));
        return ResponseEntity.ok().body(interviewService.edit(interviewDto));
    }
}
