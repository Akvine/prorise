package ru.akvine.prorise.service.dto.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.task.PriorityType;
import ru.akvine.prorise.entities.task.StatusType;
import ru.akvine.prorise.entities.task.TaskEntity;
import ru.akvine.prorise.service.dto.BaseBean;
import ru.akvine.prorise.service.dto.employer.EmployerBean;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TaskBean extends BaseBean<Long> {
    private String title;
    private String description;
    private LocalDate startDate;
    @Nullable
    private LocalDate endDate;
    private PriorityType priorityType;
    private EmployerBean employer;
    private StatusType statusType;
    private boolean done;

    public TaskBean(TaskEntity entity) {
        super(entity);
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.startDate = entity.getStartedDate();
        this.endDate = entity.getEndDate();
        this.priorityType = entity.getPriority();
        this.statusType = entity.getStatus();
        this.done = entity.isDone();
    }
}
