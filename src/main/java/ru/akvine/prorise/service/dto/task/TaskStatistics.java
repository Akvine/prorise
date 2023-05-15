package ru.akvine.prorise.service.dto.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatistics {
    private long countCompletedTasks;
    private double effectiveness;
    private LocalDateTime averageTaskCompletionTime;
    private LocalDateTime maxTaskCompletionTime;
    private LocalDateTime minTaskCompletionTime;
}
