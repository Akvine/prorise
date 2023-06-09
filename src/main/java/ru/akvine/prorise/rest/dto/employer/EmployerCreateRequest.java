package ru.akvine.prorise.rest.dto.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class EmployerCreateRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @Nullable
    private String thirdName;

    @NotBlank
    private String teamUuid;

    @NotBlank
    private String employmentDate;

    @Nullable
    private String dismissalDate;

    @NotBlank
    private String employerType;
}
