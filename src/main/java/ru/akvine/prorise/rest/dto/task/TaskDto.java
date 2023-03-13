package ru.akvine.prorise.rest.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.BaseDto;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class TaskDto extends BaseDto {
    private String title;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String priority;

    private String employerUuid;

    private String status;

    private boolean done;
}
