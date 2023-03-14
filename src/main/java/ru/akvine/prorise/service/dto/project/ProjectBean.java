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
public class ProjectBean extends BaseBean<Long> {
    private LocalDate startDate;
    @Nullable
    private LocalDate endDate;
    @Nullable
    private String description;
    private ProjectType projectType;
    private List<GoalBean> goals;
    private boolean done;

    public ProjectBean(ProjectEntity entity) {
        super(entity);
        this.startDate = entity.getStartedDate();
        this.endDate = entity.getEndDate();
        this.description = entity.getDescription();
        this.projectType = entity.getType();
        this.done = entity.isDone();
        this.goals = entity
                .getGoals()
                .stream()
                .map(GoalBean::new)
                .collect(Collectors.toList());
    }
}
