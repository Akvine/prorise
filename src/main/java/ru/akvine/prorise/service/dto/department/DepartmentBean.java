package ru.akvine.prorise.service.dto.department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.department.DepartmentEntity;
import ru.akvine.prorise.entities.department.DepartmentType;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class DepartmentBean {
    private Long id;
    private String uuid;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private String title;
    private boolean deleted;
    @Nullable
    private String description;
    private DepartmentType type;
    private DepartmentTypeBean departmentType;

    public DepartmentBean(DepartmentEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
        this.deletedDate = entity.getDeletedDate();
        this.deleted = entity.isDeleted();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.departmentType = new DepartmentTypeBean(entity.getDepartmentType());
    }
}
