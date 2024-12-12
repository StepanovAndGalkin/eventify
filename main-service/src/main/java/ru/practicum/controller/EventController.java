package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.practicum.dto.NewEventDto;
import ru.practicum.dto.mapper.EventMapper;
import ru.practicum.model.Event;
import ru.practicum.service.EventService;
import ru.practicum.service.PersonService;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final PersonService personService;
    private final EventMapper eventMapper;

    // Отображение страницы добавления события
    @GetMapping("/add-event")
    public String showAddEventForm(Model model) {
        model.addAttribute("event", new NewEventDto());
        return "add-event";
    }

    // Обработка формы добавления события
    @PostMapping("/add-event")
    public String addEvent(@ModelAttribute("event") NewEventDto eventDto,
                           Model model,
                           Principal principal) {
        Event newEvent = eventMapper.toEntity(eventDto);
        newEvent.setAuthor(personService.getByEmail(principal.getName()));
        newEvent.setCreated_time(LocalDateTime.now());
        newEvent.setRating(0L);
        eventService.add(newEvent);
        return "success";
    }


}