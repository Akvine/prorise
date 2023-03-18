package ru.akvine.prorise.rest.dto.goal;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class GoalUpdateRequest {
    @NotBlank
    private String uuid;

    @Nullable
    private String title;

    @Nullable
    private String projectUuid;

    @Nullable
    private String description;

    private boolean done;
}
