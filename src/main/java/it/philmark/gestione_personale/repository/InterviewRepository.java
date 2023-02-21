package it.philmark.gestione_personale.repository;

import it.philmark.gestione_personale.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
