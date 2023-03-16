package ru.akvine.prorise.service.dto.team;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.service.dto.department.DepartmentBean;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class TeamBean {
    private Long id;
    private String uuid;
    private String title;
    private String description;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private DepartmentBean departmentBean;
    private boolean deleted;

    public TeamBean(TeamEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.title = entity.getTitle();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
        this.deletedDate = entity.getDeletedDate();
        this.description = entity.getDescription();
        this.deleted = entity.isDeleted();
        this.departmentBean = new DepartmentBean(entity.getDepartmentEntity());
    }
}
