package ru.akvine.prorise.rest.dto.kpi;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Accessors(chain = true)
public class GetKPIRequest {
    @NotBlank
    private String employerUuid;

    @NotEmpty
    private List<String> filters;
}
