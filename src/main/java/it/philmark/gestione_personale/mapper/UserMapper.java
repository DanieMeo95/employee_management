package it.philmark.gestione_personale.mapper;

import it.philmark.gestione_personale.dto.UserDto;
import it.philmark.gestione_personale.model.User;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@NoArgsConstructor
public class UserMapper implements Mapper<User, UserDto> {
    @Override
    public User mapDtoToEntityImpl(UserDto dto) throws RuntimeException {

        return User.builder()
                .id(dto.getId() != null ? dto.getId() : null)
                .name(dto.getName())
                .surname(dto.getSurname())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();

    }

    @Override
    public UserDto mapEntityToDtoImpl(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .build();
    }
}
