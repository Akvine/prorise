package ru.akvine.prorise.rest.converter;

import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.project.ProjectDto;
import ru.akvine.prorise.service.dto.project.ProjectBean;

@Component
public class ProjectConverter extends BaseConverter<ProjectDto, ProjectBean> {
    @Override
    protected ProjectDto convertBeanToDto(ProjectBean bean) {
        return null;
    }

    @Override
    protected ProjectBean convertDtoToBean(ProjectDto dto) {
        return null;
    }

    @Override
    protected ProjectBean createEmptyBean() {
        return null;
    }
}
