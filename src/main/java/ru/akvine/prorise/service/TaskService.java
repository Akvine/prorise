package ru.akvine.prorise.service;

import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.task.TaskEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.repositories.BaseRepository;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
public class TaskService extends BaseService<TaskBean, TaskEntity> {
    public TaskService(UuidGenerator uuidGenerator) {
        super(uuidGenerator);
    }

    @Override
    protected BaseRepository<TaskEntity> getRepository() {
        return null;
    }

    @Override
    protected TaskEntity createEmptyEntity() {
        return null;
    }

    @Override
    protected TaskBean convertEntityToBean(TaskEntity entity) {
        return null;
    }

    @Override
    protected TaskEntity convertBeanToEntity(TaskBean bean, TaskEntity entity) {
        return null;
    }

    @Override
    protected BaseEntityNotFoundException createNotFoundException(String uuid) {
        return null;
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(TaskBean bean) {
        return null;
    }
}
