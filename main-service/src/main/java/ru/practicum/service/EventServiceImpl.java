package ru.practicum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.model.Event;
import ru.practicum.repository.EventRepository;

@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;


    @Override
    public Event add(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event get(long id) {
        return eventRepository.findById(id).orElseThrow();
    }

    @Override
    public Event update(Event event) {
        return null;
    }
}
