package ru.akvine.prorise.rest.dto.project;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class ProjectCreateRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String startDate;

    @Nullable
    private String endDate;

    @NotBlank
    private String teamUuid;

    @Nullable
    private String description;

    @NotBlank
    private String type;

    private boolean done;
}
