package it.philmark.gestione_personale.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Include
        @Column(name = "id_user")
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "surname")
        private String surname;
        @Column(name = "username")
        private String username;
        @Column(name = "password")
        private String password;
}
