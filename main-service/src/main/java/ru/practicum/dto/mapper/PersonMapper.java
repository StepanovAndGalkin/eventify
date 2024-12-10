package ru.practicum.dto.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.practicum.dto.AdminPersonDto;
import ru.practicum.dto.PersonDto;
import ru.practicum.dto.RequestPersonDto;
import ru.practicum.dto.UpdatePersonDto;
import ru.practicum.model.Person;

@Mapper
public interface PersonMapper {
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    Person toEntity(PersonDto personDto);

    PersonDto toPersonDto(Person person);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    Person toEntity(RequestPersonDto requestPersonDto);

    RequestPersonDto toRequestPersonDto(Person person);

    @Mapping(target = "role", ignore = true)
    @Mapping(target = "id", ignore = true)
    Person toEntity(UpdatePersonDto updatePersonDto);

    @Mapping(target = "id", ignore = true)
    Person toEntity(AdminPersonDto adminPersonDto);

    @InheritInverseConfiguration(name = "toEntity")
    AdminPersonDto toAdminPersonDto(Person person);
}