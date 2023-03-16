package ru.akvine.prorise.service.dto.task;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.task.PriorityType;
import ru.akvine.prorise.entities.task.StatusType;
import ru.akvine.prorise.entities.task.TaskEntity;
import ru.akvine.prorise.service.dto.employer.EmployerBean;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TaskBean {
    private Long id;
    private String uuid;
    private String title;
    private String description;
    private String employerUuid;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private LocalDate startDate;
    @Nullable
    private LocalDate endDate;
    private PriorityType priorityType;
    private EmployerBean employer;
    private StatusType statusType;
    private boolean done;
    private boolean deleted;

    public TaskBean(TaskEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
        this.deletedDate = entity.getDeletedDate();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.priorityType = entity.getPriority();
        this.statusType = entity.getStatus();
        this.done = entity.isDone();
        this.deleted = entity.isDeleted();
        this.employer = new EmployerBean(entity.getEmployer());
    }
}
