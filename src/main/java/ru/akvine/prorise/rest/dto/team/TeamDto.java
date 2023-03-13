package ru.akvine.prorise.rest.dto.team;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.rest.dto.BaseDto;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class TeamDto extends BaseDto {
    @Nullable
    private String description;

    @NotBlank
    private String departmentUuid;
}
