package ru.akvine.prorise.rest.dto.kpi;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

@Data
@Accessors(chain = true)
public class GetKPIResponse extends SuccessfulResponse {
    private Integer completedTasks;
}
