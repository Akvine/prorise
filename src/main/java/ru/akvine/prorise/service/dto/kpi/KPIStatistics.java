package ru.akvine.prorise.service.dto.kpi;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class KPIStatistics {
    private int countCompletedTasks;
    private LocalDateTime averageWorkTime;
    private LocalDateTime averageArrivalTime;
    private LocalDateTime averageDepartureTime;
}
