package ru.practicum.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewEventDto {
    private String title;
    private String description;
    private LocalDateTime start_time;
}
