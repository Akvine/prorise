package ru.akvine.prorise.rest.dto.department;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class DepartmentResponse extends SuccessfulResponse {

    @NotBlank
    private String title;

    @Nullable
    private String description;

    @NotBlank
    private String type;
}
