package ru.akvine.prorise.rest.dto.project;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class ProjectUpdateRequest {
    @NotBlank
    private String uuid;

    @Nullable
    private String title;

    @Nullable
    private String startDate;

    @Nullable
    private String endDate;

    @Nullable
    private String teamUuid;

    @Nullable
    private String type;

    @Nullable
    private String description;

    private boolean done;
}
