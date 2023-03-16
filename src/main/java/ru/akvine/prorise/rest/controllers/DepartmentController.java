package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.DepartmentControllerMeta;
import ru.akvine.prorise.rest.converter.DepartmentConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.dto.department.DepartmentCreateRequest;
import ru.akvine.prorise.rest.dto.department.DepartmentUpdateRequest;
import ru.akvine.prorise.rest.validator.DepartmentValidator;
import ru.akvine.prorise.service.DepartmentService;
import ru.akvine.prorise.service.dto.department.DepartmentBean;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/departments")
public class DepartmentController implements DepartmentControllerMeta {
    private final DepartmentValidator departmentValidator;
    private final DepartmentConverter departmentConverter;
    private final DepartmentService departmentService;

    @Override
    public Response get() {
        List<DepartmentBean> departments = departmentService.get();
        return departmentConverter.convertToDepartmentListResponse(departments);
    }

    @Override
    public Response getByUuid(String uuid) {
        DepartmentBean departmentBean = departmentService.getByUuid(uuid);
        return departmentConverter.convertToDepartmentResponse(departmentBean);
    }

    @Override
    public Response create(DepartmentCreateRequest request) {
        DepartmentBean departmentBean = departmentConverter.convertToDepartmentBean(request);
        DepartmentBean createdBean = departmentService.create(departmentBean);
        return departmentConverter.convertToDepartmentResponse(createdBean);
    }

    @Override
    public Response update(DepartmentUpdateRequest request) {
        DepartmentBean departmentBean = departmentConverter.convertToDepartmentBean(request);
        DepartmentBean updatedBean = departmentService.update(departmentBean);
        return departmentConverter.convertToDepartmentResponse(updatedBean);
    }

    @Override
    public Response deleteByUuid(String uuid) {
        departmentService.deleteByUuid(uuid);
        return new SuccessfulResponse();
    }
}
