package ru.akvine.prorise.rest.dto.project;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.goal.GoalDto;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
public class ProjectDto extends BaseDto {
    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private String projectType;

    private List<GoalDto> goals;

    private boolean done;
}
