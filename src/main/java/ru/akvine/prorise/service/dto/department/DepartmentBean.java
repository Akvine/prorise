package ru.akvine.prorise.service.dto.department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.department.DepartmentEntity;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.service.dto.BaseBean;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class DepartmentBean extends BaseBean<Long> {
    private String title;
    @Nullable
    private String description;
    private DepartmentType type;
    private DepartmentTypeBean departmentType;

    public DepartmentBean(DepartmentEntity entity) {
        super(entity);
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.departmentType = new DepartmentTypeBean(entity.getDepartmentType());
    }
}
