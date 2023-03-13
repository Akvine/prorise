package ru.akvine.prorise.rest.dto.goal;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.BaseDto;
import ru.akvine.prorise.rest.dto.task.TaskDto;

import java.util.List;

@Data
@Accessors(chain = true)
public class GoalDto extends BaseDto {
    private String description;

    private List<TaskDto> tasks;

    private boolean done;
}
