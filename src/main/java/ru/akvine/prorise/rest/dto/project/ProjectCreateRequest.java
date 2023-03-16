package ru.akvine.prorise.rest.dto.project;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class ProjectCreateRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private boolean done;
}
