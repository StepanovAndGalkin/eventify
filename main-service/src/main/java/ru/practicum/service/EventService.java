package ru.practicum.service;

import ru.practicum.model.Event;

public interface EventService {

    public Event add(Event event);

    public Event get(long id);

    public Event update(Event event);
}
