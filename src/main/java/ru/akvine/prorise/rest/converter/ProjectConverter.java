package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.project.ProjectType;
import ru.akvine.prorise.rest.dto.project.ProjectCreateRequest;
import ru.akvine.prorise.rest.dto.project.ProjectListResponse;
import ru.akvine.prorise.rest.dto.project.ProjectResponse;
import ru.akvine.prorise.rest.dto.project.ProjectUpdateRequest;
import ru.akvine.prorise.service.dto.project.ProjectBean;
import ru.akvine.prorise.utils.DateUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProjectConverter {
    private final DateUtils dateUtils;

    public ProjectBean convertToProjectBean(ProjectCreateRequest request) {
        Preconditions.checkNotNull(request, "projectCreateRequest is null");
        return new ProjectBean()
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDone(request.isDone())
                .setStartDate(dateUtils.toLocalDate(request.getStartDate()))
                .setEndDate(dateUtils.toLocalDate(request.getEndDate()))
                .setTeamUuid(request.getTeamUuid())
                .setProjectType(request.getType() == null ? null : ProjectType.valueOf(request.getType()));
    }

    public ProjectBean convertToProjectBean(ProjectUpdateRequest request) {
        Preconditions.checkNotNull(request, "projectUpdateRequest is null");
        return new ProjectBean()
                .setUuid(request.getUuid())
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDone(request.isDone())
                .setStartDate(dateUtils.toLocalDate(request.getStartDate()))
                .setEndDate(dateUtils.toLocalDate(request.getEndDate()))
                .setTeamUuid(request.getTeamUuid())
                .setProjectType(request.getType() == null ? null : ProjectType.valueOf(request.getType()));
    }

    public ProjectResponse convertToProjectResponse(ProjectBean projectBean) {
        Preconditions.checkNotNull(projectBean, "projectBean is null");
        return new ProjectResponse()
                .setStartDate(projectBean.getStartDate())
                .setEndDate(projectBean.getEndDate())
                .setDescription(projectBean.getDescription())
                .setTitle(projectBean.getTitle())
                .setDone(projectBean.isDone())
                .setType(projectBean.getProjectType().name())
                .setTeamUuid(projectBean.getTeamBean().getUuid());
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
