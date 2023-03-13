package ru.akvine.prorise.service;

import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.repositories.BaseRepository;
import ru.akvine.prorise.service.dto.goal.GoalBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
public class GoalService extends BaseService<GoalBean, GoalEntity> {
    public GoalService(UuidGenerator uuidGenerator) {
        super(uuidGenerator);
    }

    @Override
    protected BaseRepository<GoalEntity> getRepository() {
        return null;
    }

    @Override
    protected GoalEntity createEmptyEntity() {
        return null;
    }

    @Override
    protected GoalBean convertEntityToBean(GoalEntity entity) {
        return null;
    }

    @Override
    protected GoalEntity convertBeanToEntity(GoalBean bean, GoalEntity entity) {
        return null;
    }

    @Override
    protected BaseEntityNotFoundException createNotFoundException(String uuid) {
        return null;
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(GoalBean bean) {
        return null;
    }
}
