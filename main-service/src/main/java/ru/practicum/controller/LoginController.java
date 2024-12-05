package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.practicum.dto.RequestPersonDto;
import ru.practicum.dto.mapper.PersonMapper;
import ru.practicum.model.Person;
import ru.practicum.service.RegistrationService;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final RegistrationService registrationService;
    private final PersonMapper mapper;

    @GetMapping("/home")
    public String sayHello() {
        return "hello";
    }

    // Отображение страницы регистрации
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "registration";
    }

    // Обработка формы регистрации
    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("person") RequestPersonDto personDto, Model model) {
        // Сохранение пользователя
        registrationService.register(mapper.toEntity(personDto));

        // Передача сообщения об успешной регистрации
        model.addAttribute("message", "Поздравляем с успешной регистрацией!");
        return "success";
    }


}