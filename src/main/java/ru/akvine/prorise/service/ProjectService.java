package ru.akvine.prorise.service;

import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.project.ProjectEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.exceptions.project.ProjectEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.project.ProjectEntityNotFoundException;
import ru.akvine.prorise.repositories.BaseRepository;
import ru.akvine.prorise.repositories.ProjectRepository;
import ru.akvine.prorise.service.dto.project.ProjectBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
public class ProjectService extends BaseService<ProjectBean, ProjectEntity> {
    private final ProjectRepository projectRepository;

    public ProjectService(UuidGenerator uuidGenerator, ProjectRepository projectRepository) {
        super(uuidGenerator);
        this.projectRepository = projectRepository;
    }

    @Override
    protected BaseRepository<ProjectEntity> getRepository() {
        return projectRepository;
    }

    @Override
    protected ProjectEntity createEmptyEntity() {
        return new ProjectEntity();
    }

    @Override
    protected ProjectBean convertEntityToBean(ProjectEntity entity) {
        return new ProjectBean(entity);
    }

    @Override
    protected ProjectEntity convertBeanToEntity(ProjectBean bean, ProjectEntity entity) {
        return entity
                .setDescription(bean.getDescription())
                .setStartedDate(entity.getStartedDate())
                .setEndDate(bean.getEndDate())
                .setType(bean.getProjectType())
                .setDone(bean.isDone());
    }

    @Override
    protected BaseEntityNotFoundException createNotFoundException(String uuid) {
        return new ProjectEntityNotFoundException(uuid);
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(ProjectBean bean) {
        return new ProjectEntityAlreadyFoundException(bean);
    }
}
