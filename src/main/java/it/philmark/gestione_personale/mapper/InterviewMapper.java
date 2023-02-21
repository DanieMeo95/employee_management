package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.InterviewDto;
import it.philmark.gestione_personale.model.Interview;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class InterviewMapper implements Mapper<Interview, InterviewDto> {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public Interview mapDtoToEntityImpl(InterviewDto dto) throws RuntimeException {
        return Interview.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .cv(dto.getCv())
                .date(dto.getDate())
                .passed(dto.getPassed())
                .task(taskMapper.mapDtoToEntity(dto.getTask()))
                .resource(resourceMapper.mapDtoToEntity(dto.getResource()))
                .build();
    }

    @Override
    public InterviewDto mapEntityToDtoImpl(Interview entity) {
        return InterviewDto.builder()
                .id(entity.getId())
                .cv(entity.getCv())
                .date(entity.getDate())
                .passed(entity.getPassed())
                .task(taskMapper.mapEntityToDto(entity.getTask()))
                .resource(resourceMapper.mapEntityToDto(entity.getResource()))
                .build();
    }
}
