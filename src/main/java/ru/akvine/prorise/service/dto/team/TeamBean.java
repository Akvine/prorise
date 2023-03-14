package ru.akvine.prorise.service.dto.team;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.service.dto.employer.EmployerBean;
import ru.akvine.prorise.service.dto.project.ProjectBean;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TeamBean extends BaseBean<Long> {
    private String description;
    @Nullable
    private String departmentUuid;
    private List<EmployerBean> employers;
    private List<ProjectBean> projects;

    public TeamBean(TeamEntity entity) {
        super(entity);
        this.description = entity.getDescription();
        this.departmentUuid = entity.getUuid();
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
