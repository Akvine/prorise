package ru.akvine.prorise.rest.dto.department;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import javax.validation.Valid;
import java.util.List;

@Data
@Accessors(chain = true)
public class DepartmentListResponse extends SuccessfulResponse {
    @Valid
    private List<DepartmentResponse> departments;
}
