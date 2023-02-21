package it.philmark.gestione_personale.service;

import it.philmark.gestione_personale.dto.UserDto;
import it.philmark.gestione_personale.model.User;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    List<UserDto> findAll();
    void insertUser(UserDto userDto);

    void editUser(UserDto userDto);
}
