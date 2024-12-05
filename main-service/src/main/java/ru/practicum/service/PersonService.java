package ru.practicum.service;

import ru.practicum.model.Person;

public interface PersonService {

    Person getById(long id);

    Person update(Person person);

    void delete(long id);
}