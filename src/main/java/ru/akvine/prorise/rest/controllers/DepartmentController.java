package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.DepartmentConverter;
import ru.akvine.prorise.rest.validator.DepartmentValidator;
import ru.akvine.prorise.service.DepartmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/departments")
public class DepartmentController {
    private final DepartmentValidator departmentValidator;
    private final DepartmentConverter departmentConverter;
    private final DepartmentService departmentService;

}
