package ru.akvine.prorise.rest.dto.team;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TeamUpdateRequest {
    @NotBlank
    private String uuid;

    @Nullable
    private String departmentUuid;

    @NotBlank
    private String title;

    @Nullable
    private String description;
}
