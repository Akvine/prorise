package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.BaseConverter;
import ru.akvine.prorise.rest.converter.DepartmentConverter;
import ru.akvine.prorise.rest.dto.department.DepartmentDto;
import ru.akvine.prorise.rest.validator.BaseValidator;
import ru.akvine.prorise.rest.validator.DepartmentValidator;
import ru.akvine.prorise.service.BaseService;
import ru.akvine.prorise.service.DepartmentService;
import ru.akvine.prorise.service.dto.department.DepartmentBean;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/departments")
public class DepartmentController extends BaseController<DepartmentDto, DepartmentBean> {
    private final DepartmentValidator departmentValidator;
    private final DepartmentConverter departmentConverter;
    private final DepartmentService departmentService;

    @Override
    protected BaseValidator getValidator() {
        return departmentValidator;
    }

    @Override
    protected BaseConverter getConverter() {
        return departmentConverter;
    }

    @Override
    protected BaseService getService() {
        return departmentService;
    }
}
