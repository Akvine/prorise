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

    @Nullable
    private String firstName;

    @Nullable
    private String secondName;

    @Nullable
    private String thirdName;

    @Nullable
    private String teamUuid;

    @Nullable
    private LocalDate employmentDate;

    @Nullable
    private LocalDate dismissalDate;

    @Nullable
    private String employerType;
}
