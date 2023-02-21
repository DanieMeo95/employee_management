package it.philmark.gestione_personale.service.serviceImpl;

import it.philmark.gestione_personale.dto.InterviewDto;
import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.exception.Messages;
import it.philmark.gestione_personale.mapper.InterviewMapper;
import it.philmark.gestione_personale.repository.InterviewRepository;
import it.philmark.gestione_personale.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private InterviewMapper interviewMapper;

    @Override
    public InterviewDto findById(Long id) {
        return interviewMapper.mapEntityToDto(interviewRepository.findById(id).orElseThrow(() -> new EmployeeManagementException(Messages.erroreGenerico)));
    }

    @Override
    public List<InterviewDto> findAll() {
        return interviewMapper.mapEntityToDto(interviewRepository.findAll());
    }

    @Override
    public MessageDto insert(InterviewDto interviewDto) {
        interviewRepository.save(interviewMapper.mapDtoToEntity(interviewDto));
        return new MessageDto(Messages.successInsert, HttpStatus.OK);

    }

    @Override
    public MessageDto edit(InterviewDto interviewDto) {
        interviewRepository.save(interviewMapper.mapDtoToEntity(interviewDto));
        return new MessageDto(Messages.successEdit, HttpStatus.OK);
    }
}
