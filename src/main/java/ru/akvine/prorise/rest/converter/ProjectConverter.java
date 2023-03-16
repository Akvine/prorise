package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.project.ProjectCreateRequest;
import ru.akvine.prorise.rest.dto.project.ProjectListResponse;
import ru.akvine.prorise.rest.dto.project.ProjectResponse;
import ru.akvine.prorise.rest.dto.project.ProjectUpdateRequest;
import ru.akvine.prorise.service.dto.project.ProjectBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectConverter {
    public ProjectBean convertToProjectBean(ProjectCreateRequest request) {
        Preconditions.checkNotNull(request, "projectCreateRequest is null");
        return new ProjectBean()
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDone(request.isDone());
    }

    public ProjectBean convertToProjectBean(ProjectUpdateRequest request) {
        Preconditions.checkNotNull(request, "projectUpdateRequest is null");
        return new ProjectBean()
                .setUuid(request.getUuid())
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDone(request.isDone());
    }

    public ProjectResponse convertToProjectResponse(ProjectBean projectBean) {
        Preconditions.checkNotNull(projectBean, "projectBean is null");
        return new ProjectResponse()
                .setStartDate(projectBean.getStartDate())
                .setEndDate(projectBean.getEndDate())
                .setDescription(projectBean.getDescription())
                .setTitle(projectBean.getTitle())
                .setDone(projectBean.isDone())
                .setProjectType(projectBean.getProjectType().name());
    }

    public ProjectListResponse convertToProjectListResponse(List<ProjectBean> projects) {
        Preconditions.checkNotNull(projects, "projects is null");
        List<ProjectResponse> projectBeans = projects
                .stream()
                .map(this::convertToProjectResponse)
                .collect(Collectors.toList());
        return new ProjectListResponse()
                .setProjects(projectBeans);
    }
}
