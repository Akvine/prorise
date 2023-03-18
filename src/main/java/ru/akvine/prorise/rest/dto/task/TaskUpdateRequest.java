package ru.akvine.prorise.rest.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TaskUpdateRequest {
    @NotBlank
    private String uuid;

    @Nullable
    private String title;

    @Nullable
    private String description;

    @Nullable
    private String priority;

    @Nullable
    private String status;

    @Nullable
    private String startDate;

    @Nullable
    private String endDate;

    @Nullable
    private String employerUuid;

    @Nullable
    private String goalUuid;

    private boolean done;
}
