package ru.akvine.prorise.service.dto.kpi;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class KPIResult {
    private Integer completedTasks;
}
