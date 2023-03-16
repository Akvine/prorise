package ru.akvine.prorise.rest.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TaskUpdateRequest {
    @NotBlank
    private String uuid;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String priority;

    @NotBlank
    private String status;

    @NotBlank
    private String employerUuid;

    private boolean done;
}
