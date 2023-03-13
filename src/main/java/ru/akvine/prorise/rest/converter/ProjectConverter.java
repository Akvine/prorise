package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.project.ProjectType;
import ru.akvine.prorise.rest.dto.goal.GoalDto;
import ru.akvine.prorise.rest.dto.project.ProjectDto;
import ru.akvine.prorise.service.dto.goal.GoalBean;
import ru.akvine.prorise.service.dto.project.ProjectBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectConverter extends BaseConverter<ProjectDto, ProjectBean> {
    @Override
    protected ProjectDto convertBeanToDto(ProjectBean projectBean) {
        Preconditions.checkNotNull(projectBean, "projectBean is null");
        List<GoalDto> goals = projectBean
                .getGoals()
                .stream()
                .map(this::buildGoalDto)
                .collect(Collectors.toList());
        return new ProjectDto()
                .setStartDate(projectBean.getStartDate())
                .setEndDate(projectBean.getEndDate())
                .setDescription(projectBean.getDescription())
                .setDone(projectBean.isDone())
                .setProjectType(projectBean.getProjectType().name())
                .setGoals(goals);
    }

    @Override
    protected ProjectBean convertDtoToBean(ProjectDto projectDto) {
        Preconditions.checkNotNull(projectDto, "projectDto is null");
        return new ProjectBean()
                .setStartDate(projectDto.getStartDate())
                .setEndDate(projectDto.getEndDate())
                .setDescription(projectDto.getDescription())
                .setProjectType(ProjectType.valueOf(projectDto.getProjectType()))
                .setDone(projectDto.isDone());
    }

    @Override
    protected ProjectBean createEmptyBean() {
        return new ProjectBean();
    }

    private GoalDto buildGoalDto(GoalBean goalBean) {
        return new GoalDto()
                .setDescription(goalBean.getDescription())
                .setDone(goalBean.isDone());
    }
}
