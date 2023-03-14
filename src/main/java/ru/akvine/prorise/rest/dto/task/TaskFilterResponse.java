package ru.akvine.prorise.rest.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import java.util.List;

@Data
@Accessors(chain = true)
public class TaskFilterResponse extends SuccessfulResponse {
    private int count;
    private List<TaskDto> tasks;
}
