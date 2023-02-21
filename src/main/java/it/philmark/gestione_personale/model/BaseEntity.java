package it.philmark.gestione_personale.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    public abstract Long getId();

    public abstract void setId(Long id);

    @Column(name = "creation_user")
    private Long creationUser;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "edit_user")
    private Long editUser;
    @Column(name = "edit_date")
    private LocalDateTime editDate;
}