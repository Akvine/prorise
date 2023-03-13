package ru.akvine.prorise.service;

import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.project.ProjectEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.repositories.BaseRepository;
import ru.akvine.prorise.service.dto.project.ProjectBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
public class ProjectService extends BaseService<ProjectBean, ProjectEntity> {
    public ProjectService(UuidGenerator uuidGenerator) {
        super(uuidGenerator);
    }

    @Override
    protected BaseRepository<ProjectEntity> getRepository() {
        return null;
    }

    @Override
    protected ProjectEntity createEmptyEntity() {
        return null;
    }

    @Override
    protected ProjectBean convertEntityToBean(ProjectEntity entity) {
        return null;
    }

    @Override
    protected ProjectEntity convertBeanToEntity(ProjectBean bean, ProjectEntity entity) {
        return null;
    }

    @Override
    protected BaseEntityNotFoundException createNotFoundException(String uuid) {
        return null;
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(ProjectBean bean) {
        return null;
    }
}
