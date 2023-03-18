package ru.akvine.prorise.rest.dto.goal;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

@Data
@Accessors(chain = true)
public class GoalResponse extends SuccessfulResponse {
    private String title;

    private String description;

    private String projectUuid;

    private boolean done;
}
