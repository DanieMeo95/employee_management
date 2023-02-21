package it.philmark.gestione_personale.controller;

import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.SkillDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/{id}")
    public ResponseEntity<SkillDto> findById(@PathVariable("id") String id) throws EmployeeManagementException {
        return ResponseEntity.ok().body(skillService.findById(Long.parseLong(id)));
    }

    @GetMapping("/listAll")
    public ResponseEntity<List<SkillDto>> listAll() throws EmployeeManagementException {
        return ResponseEntity.status(HttpStatus.OK).body(skillService.findAll());
    }

    @PostMapping("/insert")
    public ResponseEntity<MessageDto> insert(@RequestBody SkillDto skillDto,
                                                     BindingResult bindingResult) throws EmployeeManagementException {

        if (bindingResult.hasErrors()) throw new EmployeeManagementException(bindingResult.getAllErrors().stream()
                .map(error -> error.getDefaultMessage()).reduce("", (str1, str2) -> str1 + " " + str2));
        return ResponseEntity.ok().body(skillService.insert(skillDto));
    }
}
