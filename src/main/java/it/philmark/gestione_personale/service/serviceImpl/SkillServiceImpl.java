package it.philmark.gestione_personale.service.serviceImpl;

import it.philmark.gestione_personale.dto.MessageDto;
import it.philmark.gestione_personale.dto.SkillDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.exception.Messages;
import it.philmark.gestione_personale.mapper.SkillMapper;
import it.philmark.gestione_personale.repository.SkillRepository;
import it.philmark.gestione_personale.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillMapper skillMapper;

    @Override
    public SkillDto findById(Long id) {
        return skillMapper.mapEntityToDto(skillRepository.findById(id).orElseThrow(() -> new EmployeeManagementException(Messages.erroreGenerico)));
    }

    @Override
    public List<SkillDto> findAll() {
        return skillMapper.mapEntityToDto(skillRepository.findAll());
    }

    @Override
    public MessageDto insert(SkillDto skillDto) {
        skillRepository.save(skillMapper.mapDtoToEntity(skillDto));
        return new MessageDto(Messages.successInsert, HttpStatus.OK);
    }

    @Override
    public void edit(SkillDto skillDto) {
        skillRepository.save(skillMapper.mapDtoToEntity(skillDto));
    }
}
