package ru.akvine.prorise.rest.dto.department;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class DepartmentUpdateRequest {
    @NotBlank
    private String uuid;

    @Nullable
    private String title;

    @Nullable
    private String description;

    @Nullable
    private String type;
}
