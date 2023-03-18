package ru.akvine.prorise.rest.dto.project;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class ProjectUpdateRequest {
    @NotBlank
    private String uuid;

    @NotBlank
    private String title;

    @NotBlank
    private LocalDate startDate;

    @NotBlank
    private LocalDate endDate;

    @Nullable
    private String teamUuid;

    @NotBlank
    private String description;

    private boolean done;
}
