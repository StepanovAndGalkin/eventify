package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.practicum.model.Person;
import ru.practicum.repository.PersonRepository;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public Person register(String name, String email, String password) {
        Person person = new Person();
        person.setName(name);
        person.setEmail(email);
        person.setPassword(passwordEncoder.encode(password)); // Хэшируем пароль
        return personRepository.save(person);
    }
}
