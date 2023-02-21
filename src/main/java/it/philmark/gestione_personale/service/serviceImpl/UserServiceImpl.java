package it.philmark.gestione_personale.service.serviceImpl;

import it.philmark.gestione_personale.dto.UserDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.exception.Messages;
import it.philmark.gestione_personale.mapper.UserMapper;
import it.philmark.gestione_personale.model.User;
import it.philmark.gestione_personale.repository.UserRepository;
import it.philmark.gestione_personale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto findById(Long id) {
        return userMapper.mapEntityToDto(userRepository.findById(id).orElseThrow(()-> new EmployeeManagementException(Messages.erroreGenerico)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.mapEntityToDto(userRepository.findAll());
    }

    @Override
    public void insertUser(UserDto userDto) {
        userRepository.save(userMapper.mapDtoToEntity(userDto));
    }

    @Override
    public void editUser(UserDto userDto) {
        userRepository.save(userMapper.mapDtoToEntity(userDto));
    }

}
