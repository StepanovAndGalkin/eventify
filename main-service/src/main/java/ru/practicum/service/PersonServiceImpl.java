package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.practicum.model.Person;
import ru.practicum.repository.PersonRepository;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService, RegistrationService {
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }

    public Person getById(long id) {
        return personRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getByEmail(String email) {
        return personRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}