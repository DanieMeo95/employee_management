package it.philmark.gestione_personale.controller;

import it.philmark.gestione_personale.config.JwtTokenUtil;
import it.philmark.gestione_personale.config.JwtUserDetailsService;
import it.philmark.gestione_personale.dto.InsertUserDto;
import it.philmark.gestione_personale.dto.UserDto;
import it.philmark.gestione_personale.exception.EmployeeManagementException;
import it.philmark.gestione_personale.model.jwt.JwtRequest;
import it.philmark.gestione_personale.model.jwt.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;


@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class JwtAuthenticationController {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

    @Autowired
    private JwtUserDetailsService userService;

    @Autowired
    private AuthenticationManager autauthenticationManager;

    @PostMapping("/")
    public ResponseEntity<UserDto> signupUser(@Valid @RequestBody InsertUserDto insertUserDto,
                                              BindingResult bindingResult) throws Exception {
//		userSignUpMessageValidator.validate(insertUserDto, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new EmployeeManagementException(bindingResult);
        }
        UserDto userDto = userService.signup(insertUserDto);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        Authentication authentication = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateJwtToken(authentication);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private Authentication authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        try {
            return autauthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
