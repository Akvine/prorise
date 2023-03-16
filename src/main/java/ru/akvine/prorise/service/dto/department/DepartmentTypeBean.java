package ru.akvine.prorise.service.dto.department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.entities.department.DepartmentTypeEntity;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DepartmentTypeBean {
    private Long id;
    private String uuid;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private boolean deleted;
    private String description;
    private String code;
    private DepartmentType type;

    public DepartmentTypeBean(DepartmentTypeEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.createdDate = entity.getCreatedDate();
        this.updatedDate = entity.getUpdatedDate();
        this.deletedDate = entity.getDeletedDate();
        this.deleted = entity.isDeleted();
        this.description = entity.getDescription();
        this.code = entity.getCode();
        this.type = entity.getType();
    }
}
