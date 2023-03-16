package ru.akvine.prorise.service.dto.project;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.project.ProjectEntity;
import ru.akvine.prorise.entities.project.ProjectType;
import ru.akvine.prorise.service.dto.goal.GoalBean;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class ProjectBean {
    private Long id;
    private String uuid;
    private String title;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private LocalDate startDate;
    @Nullable
    private LocalDate endDate;
    @Nullable
    private String description;
    private ProjectType projectType;
    private List<GoalBean> goals;
    private boolean done;
    private boolean deleted;

    public ProjectBean(ProjectEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.title = entity.getTitle();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
        this.deletedDate = entity.getDeletedDate();
        this.startDate = entity.getStartedDate();
        this.endDate = entity.getEndDate();
        this.description = entity.getDescription();
        this.projectType = entity.getType();
        this.done = entity.isDone();
        this.deleted = entity.isDeleted();
        this.goals = entity
                .getGoals()
                .stream()
                .map(GoalBean::new)
                .collect(Collectors.toList());
    }
}
