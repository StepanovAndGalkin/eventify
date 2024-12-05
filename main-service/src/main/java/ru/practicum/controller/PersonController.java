package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.dto.PersonDto;
import ru.practicum.dto.UpdatePersonDto;
import ru.practicum.dto.mapper.PersonMapper;
import ru.practicum.service.PersonService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class PersonController {
    private final PersonMapper mapper;
    private final PersonService personService;

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable long id) {
        return mapper.toPersonDto(personService.getById(id));
    }

    @PatchMapping
    public PersonDto updatePerson(@RequestBody UpdatePersonDto dto) {
        return mapper.toPersonDto(personService.update(mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable long id) {
        personService.delete(id);
    }
}