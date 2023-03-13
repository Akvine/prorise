package ru.akvine.prorise.service.dto.department;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.entities.department.DepartmentTypeEntity;
import ru.akvine.prorise.service.dto.BaseBean;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class DepartmentTypeBean extends BaseBean<Long> {
    private String description;
    private String code;
    private DepartmentType type;

    public DepartmentTypeBean(DepartmentTypeEntity entity) {
        super(entity);
        this.description = entity.getDescription();
        this.code = entity.getCode();
        this.type = entity.getType();
    }
}