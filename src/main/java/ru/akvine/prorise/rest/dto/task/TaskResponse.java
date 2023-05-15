package ru.akvine.prorise.rest.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class TaskResponse extends SuccessfulResponse {
    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String priority;

    private String employerUuid;

    private String goalUuid;

    private String status;

    private boolean done;
}
