package it.philmark.gestione_personale.config;

import it.philmark.gestione_personale.dto.InsertUserDto;
import it.philmark.gestione_personale.dto.UserDto;
import it.philmark.gestione_personale.mapper.UserMapper;
import it.philmark.gestione_personale.model.User;
import it.philmark.gestione_personale.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new UserPrincipal(user);
	}
	public UserDto signup(InsertUserDto insertUserDto) {
		String username = insertUserDto.getUsername();
		String passwordEncoded = passwordEncoder.encode(insertUserDto.getPassword());

		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoded);
		user.setName(insertUserDto.getName());
		user.setSurname(insertUserDto.getSurname());
		userRepository.saveAndFlush(user);
		return userMapper.mapEntityToDto(user);
	}
}