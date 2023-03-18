package ru.akvine.prorise.rest.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TaskCreateRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String priority;

    @NotBlank
    private String startDate;

    @Nullable
    private String endDate;

    @NotBlank
    private String status;

    @NotBlank
    private String employerUuid;

    @NotBlank
    private String goalUuid;

    private boolean done;
}
