package ru.practicum.dto.mapper;

import org.mapstruct.Mapper;
import ru.practicum.dto.NewEventDto;
import ru.practicum.model.Event;

@Mapper
public interface EventMapper {

    Event toEntity(NewEventDto eventDto);

}