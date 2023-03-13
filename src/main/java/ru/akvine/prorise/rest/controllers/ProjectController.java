package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.BaseConverter;
import ru.akvine.prorise.rest.converter.ProjectConverter;
import ru.akvine.prorise.rest.dto.project.ProjectDto;
import ru.akvine.prorise.rest.validator.BaseValidator;
import ru.akvine.prorise.rest.validator.ProjectValidator;
import ru.akvine.prorise.service.BaseService;
import ru.akvine.prorise.service.ProjectService;
import ru.akvine.prorise.service.dto.project.ProjectBean;

@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController extends BaseController<ProjectDto, ProjectBean> {
    private final ProjectValidator projectValidator;
    private final ProjectService projectService;
    private final ProjectConverter projectConverter;

    @Override
    protected BaseValidator getValidator() {
        return projectValidator;
    }

    @Override
    protected BaseConverter getConverter() {
        return projectConverter;
    }

    @Override
    protected BaseService getService() {
        return projectService;
    }
}
