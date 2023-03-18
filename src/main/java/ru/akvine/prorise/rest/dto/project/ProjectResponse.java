package ru.akvine.prorise.rest.dto.project;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.dto.goal.GoalResponse;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProjectResponse extends SuccessfulResponse {
    private LocalDate startDate;

    private LocalDate endDate;

    private String title;

    private String description;

    private String type;

    private String teamUuid;

    private boolean done;
}
