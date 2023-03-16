package ru.akvine.prorise.service.dto.goal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.service.dto.project.ProjectBean;
import ru.akvine.prorise.service.dto.task.TaskBean;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GoalBean {
    private Long id;
    private String uuid;
    private String title;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private boolean deleted;
    private String description;
    private ProjectBean projectBean;
    private boolean done;

    public GoalBean(GoalEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.title = entity.getTitle();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
        this.deletedDate = entity.getDeletedDate();
        this.deleted = entity.isDeleted();
        this.done = entity.isDone();
        this.description = entity.getDescription();
        this.projectBean = new ProjectBean(entity.getProject());
    }
}
