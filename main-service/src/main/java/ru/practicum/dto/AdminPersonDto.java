package ru.practicum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link ru.practicum.model.Person}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminPersonDto {
    private String name;
    private String email;
    private String password;
    private String role;
}