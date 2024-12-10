package ru.practicum.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.practicum.dto.AdminPersonDto;
import ru.practicum.dto.RequestPersonDto;
import ru.practicum.dto.mapper.PersonMapper;
import ru.practicum.model.Person;
import ru.practicum.service.RegistrationService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final RegistrationService registrationService;
    private final PersonMapper mapper;

    @GetMapping("/home")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/registration")
    public String showUserRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "user-registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("person") RequestPersonDto personDto, Model model) {
        log.info("User registration {}", personDto);
        registrationService.register(mapper.toEntity(personDto));

        model.addAttribute("message", "Поздравляем с успешной регистрацией!");
        return "success";
    }

    @GetMapping("/admin/registration")
    @Secured("ROLE_ADMIN")
    public String showAdminRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "admin-registration";
    }

    @PostMapping("/admin/registration")
    @Secured("ROLE_ADMIN")
    public String makeRegistrationAnAdmin(@ModelAttribute("person") AdminPersonDto adminPersonDtoDto, Model model) {
        log.info("Admin registration {}", adminPersonDtoDto);
        registrationService.register(mapper.toEntity(adminPersonDtoDto));
        model.addAttribute("message", "Пользователь создан");
        return "success";
    }
}