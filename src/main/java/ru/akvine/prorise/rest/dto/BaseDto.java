package ru.akvine.prorise.rest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BaseDto {
    private String uuid;
    private String title;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
