package ru.akvine.prorise.rest.dto.team;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TeamResponse extends SuccessfulResponse {
    @Nullable
    private String description;

    @NotBlank
    private String title;

    @NotBlank
    private String departmentUuid;
}
