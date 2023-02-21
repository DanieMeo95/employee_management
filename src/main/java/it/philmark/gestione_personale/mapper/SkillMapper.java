package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.SkillDto;
import it.philmark.gestione_personale.model.Skill;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class SkillMapper implements Mapper<Skill, SkillDto> {

    @Override
    public Skill mapDtoToEntityImpl(SkillDto dto) throws RuntimeException {
        return Skill.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .description(dto.getDescription())
                .build();
    }

    @Override
    public SkillDto mapEntityToDtoImpl(Skill entity) {
        return SkillDto.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .build();
    }
}
