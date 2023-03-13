package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.rest.dto.department.DepartmentDto;
import ru.akvine.prorise.service.dto.department.DepartmentBean;

@Component
public class DepartmentConverter extends BaseConverter<DepartmentDto, DepartmentBean> {
    @Override
    protected DepartmentDto convertBeanToDto(DepartmentBean bean) {
        Preconditions.checkNotNull(bean, "departmentBean is null");
        return new DepartmentDto()
                .setTitle(bean.getTitle())
                .setDescription(bean.getDescription())
                .setDepartmentType(bean.getDepartmentType().toString());
    }

    @Override
    protected DepartmentBean convertDtoToBean(DepartmentDto dto) {
        Preconditions.checkNotNull(dto, "departmentDto is null");
        return new DepartmentBean()
                .setTitle(dto.getTitle())
                .setDescription(dto.getDescription())
                .setType(DepartmentType.safeValueOf(dto.getDepartmentType()));
    }

    @Override
    protected DepartmentBean createEmptyBean() {
        return new DepartmentBean();
    }
}
