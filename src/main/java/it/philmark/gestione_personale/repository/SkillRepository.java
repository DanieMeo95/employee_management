package it.philmark.gestione_personale.repository;

import it.philmark.gestione_personale.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
