package ru.practicum.service;

import ru.practicum.model.Person;

public interface PersonService {

    Person getById(long id);

    Person update(Person person);

    Person getByEmail(String email);

    void delete(long id);
}