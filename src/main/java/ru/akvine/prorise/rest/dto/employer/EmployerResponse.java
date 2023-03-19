package ru.akvine.prorise.rest.dto.employer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
public class EmployerResponse extends SuccessfulResponse {
    @NotBlank
    private String uuid;

    @NotBlank
    private String firstName;

    @NotBlank
    private String secondName;

    @Nullable
    private String thirdName;

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate employmentDate;

    @Nullable
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dismissalDate;

    @NotBlank
    private String employmentType;

    @NotBlank
    private String teamUuid;
}
