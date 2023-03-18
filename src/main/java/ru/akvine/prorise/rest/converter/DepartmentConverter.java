package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.rest.dto.department.DepartmentCreateRequest;
import ru.akvine.prorise.rest.dto.department.DepartmentListResponse;
import ru.akvine.prorise.rest.dto.department.DepartmentResponse;
import ru.akvine.prorise.rest.dto.department.DepartmentUpdateRequest;
import ru.akvine.prorise.service.dto.department.DepartmentBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentConverter {
    public DepartmentBean convertToDepartmentBean(DepartmentCreateRequest request) {
        Preconditions.checkNotNull(request, "departmentCreateRequest is null");
        return new DepartmentBean()
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setType(DepartmentType.safeValueOf(request.getType()));
    }

    public DepartmentBean convertToDepartmentBean(DepartmentUpdateRequest request) {
        Preconditions.checkNotNull(request, "departmentUpdateRequest is null");
        return new DepartmentBean()
                .setUuid(request.getUuid())
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setType(request.getType() == null ? null : DepartmentType.safeValueOf(request.getType()));
    }

    public DepartmentResponse convertToDepartmentResponse(DepartmentBean departmentBean) {
        Preconditions.checkNotNull(departmentBean, "departmentBean is null");
        return new DepartmentResponse()
                .setTitle(departmentBean.getTitle())
                .setDescription(departmentBean.getDescription())
                .setType(departmentBean.getDepartmentType().getType().name());
    }

    public DepartmentListResponse convertToDepartmentListResponse(List<DepartmentBean> departments) {
        Preconditions.checkNotNull(departments, "departments is null");
        List<DepartmentResponse> departmentResponses = departments
                .stream()
                .map(this::convertToDepartmentResponse)
                .collect(Collectors.toList());
        return new DepartmentListResponse()
                .setDepartments(departmentResponses);
    }
}
