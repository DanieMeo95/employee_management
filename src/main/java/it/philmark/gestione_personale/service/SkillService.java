package it.philmark.gestione_personale.service;

import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.SkillDto;

import java.util.List;

public interface SkillService {

    public SkillDto findById(Long id);

    public List<SkillDto> findAll();

    public MessageDto insert(SkillDto skillDto);

    public void edit(SkillDto skillDto);
}