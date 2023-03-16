package ru.akvine.prorise.rest.dto.project;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import javax.validation.Valid;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProjectListResponse extends SuccessfulResponse {
    @Valid
    private List<ProjectResponse> projects;
}
