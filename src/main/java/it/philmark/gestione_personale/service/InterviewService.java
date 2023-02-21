package it.philmark.gestione_personale.service;

import it.philmark.gestione_personale.dto.CustomerDto;
import it.philmark.gestione_personale.dto.InterviewDto;
import it.philmark.gestione_personale.dto.MessageDto;

import java.util.List;

public interface InterviewService {

    public InterviewDto findById(Long id);

    public List<InterviewDto> findAll();

    public MessageDto insert(InterviewDto customerDto);

    public MessageDto edit(InterviewDto customerDto);
}
