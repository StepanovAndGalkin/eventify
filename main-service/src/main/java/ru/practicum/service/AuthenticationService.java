package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.practicum.dto.JwtAuthenticationResponse;
import ru.practicum.dto.RequestPersonDto;
import ru.practicum.dto.mapper.PersonMapper;
import ru.practicum.model.Person;
import ru.practicum.security.JwtService;
import ru.practicum.security.PersonDetails;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final CustomUserDetailsService userService;
    private final RegistrationService personServiceImpl;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final PersonMapper personMapper;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signUp(RequestPersonDto request) {

        Person person = personMapper.toEntity(request);
        PersonDetails personDetails = new PersonDetails(person);
        personServiceImpl.register(person);

        var jwt = jwtService.generateToken(personDetails);
        return new JwtAuthenticationResponse(jwt);
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(RequestPersonDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));

        var user = userService
                .loadUserByUsername(request.getEmail());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}