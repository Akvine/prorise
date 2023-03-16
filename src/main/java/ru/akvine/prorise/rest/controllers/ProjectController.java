package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.ProjectControllerMeta;
import ru.akvine.prorise.rest.converter.ProjectConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.dto.project.ProjectCreateRequest;
import ru.akvine.prorise.rest.dto.project.ProjectUpdateRequest;
import ru.akvine.prorise.rest.validator.ProjectValidator;
import ru.akvine.prorise.service.ProjectService;
import ru.akvine.prorise.service.dto.project.ProjectBean;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController implements ProjectControllerMeta {
    private final ProjectValidator projectValidator;
    private final ProjectService projectService;
    private final ProjectConverter projectConverter;

    @Override
    public Response get() {
        List<ProjectBean> projects = projectService.get();
        return projectConverter.convertToProjectListResponse(projects);
    }

    @Override
    public Response getByUuid(String uuid) {
        ProjectBean project = projectService.getByUuid(uuid);
        return projectConverter.convertToProjectResponse(project);
    }

    @Override
    public Response create(ProjectCreateRequest request) {
        ProjectBean projectBean = projectConverter.convertToProjectBean(request);
        ProjectBean createdBean = projectService.create(projectBean);
        return projectConverter.convertToProjectResponse(createdBean);
    }

    @Override
    public Response update(ProjectUpdateRequest request) {
        ProjectBean projectBean = projectConverter.convertToProjectBean(request);
        ProjectBean updatedBean = projectService.update(projectBean);
        return projectConverter.convertToProjectResponse(updatedBean);
    }

    @Override
    public Response deleteByUuid(String uuid) {
        projectService.deleteByUuid(uuid);
        return new SuccessfulResponse();
    }
}
