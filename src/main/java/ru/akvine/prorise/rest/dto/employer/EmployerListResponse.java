package ru.akvine.prorise.rest.dto.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import javax.validation.Valid;
import java.util.List;

@Data
@Accessors(chain = true)
public class EmployerListResponse extends SuccessfulResponse {
    @Valid
    private List<EmployerResponse> employers;
}
