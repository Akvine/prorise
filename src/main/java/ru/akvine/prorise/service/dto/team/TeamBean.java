package ru.akvine.prorise.service.dto.team;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.service.dto.employer.EmployerBean;
import ru.akvine.prorise.service.dto.project.ProjectBean;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TeamBean {
    private Long id;
    private String uuid;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private boolean deleted;
    private String description;
    private List<EmployerBean> employers;
    private List<ProjectBean> projects;

    public TeamBean(TeamEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
        this.deletedDate = entity.getDeletedDate();
        this.description = entity.getDescription();
        this.deleted = entity.isDeleted();
        this.employers = entity
                .getEmployers()
                .stream()
                .map(EmployerBean::new)
                .collect(Collectors.toList());
        this.projects = entity
                .getProjects()
                .stream()
                .map(ProjectBean::new)
                .collect(Collectors.toList());
    }
}
