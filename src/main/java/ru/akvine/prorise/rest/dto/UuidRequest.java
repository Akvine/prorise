package ru.akvine.prorise.rest.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class UuidRequest {
    @NotBlank
    private String uuid;
}
