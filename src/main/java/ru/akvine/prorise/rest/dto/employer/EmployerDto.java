package ru.akvine.prorise.rest.dto.employer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class EmployerDto extends BaseDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @Nullable
    private String thirdName;

    @NotBlank
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate employmentDate;

    @Nullable
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate dismissalDate;

    @NotBlank
    private String employmentType;

    @NotBlank
    private String teamUuid;
}
