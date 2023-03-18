package ru.akvine.prorise.rest.dto.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class EmployerUpdateRequest {
    @NotBlank
    private String uuid;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @Nullable
    private String thirdName;

    @Nullable
    private String teamUuid;

    @NotBlank
    private LocalDate employmentDate;

    @NotBlank
    private LocalDate dismissalDate;

    @NotBlank
    private String employerType;
}
