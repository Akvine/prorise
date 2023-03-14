package ru.akvine.prorise.service;

import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.exceptions.goal.GoalEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.goal.GoalEntityNotFoundException;
import ru.akvine.prorise.repositories.GoalRepository;
import ru.akvine.prorise.service.dto.goal.GoalBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
public class GoalService extends BaseService<GoalBean, GoalEntity> {
    private final GoalRepository goalRepository;

    public GoalService(UuidGenerator uuidGenerator, GoalRepository goalRepository) {
        super(uuidGenerator);
        this.goalRepository = goalRepository;
    }

    @Override
    protected BaseRepository<GoalEntity> getRepository() {
        return goalRepository;
    }

    @Override
    protected GoalEntity createEmptyEntity() {
        return new GoalEntity();
    }

    @Override
    protected GoalBean convertEntityToBean(GoalEntity entity) {
        return new GoalBean(entity);
    }

    @Override
    protected GoalEntity convertBeanToEntity(GoalBean bean, GoalEntity entity) {
        return entity
                .setDescription(bean.getDescription())
                .setDone(bean.isDone());
    }

    @Override
    protected BaseEntityNotFoundException createNotFoundException(String uuid) {
        return new GoalEntityNotFoundException(uuid);
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(GoalBean bean) {
        return new GoalEntityAlreadyFoundException(bean);
    }
}
