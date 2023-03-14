package ru.akvine.prorise.service;

import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.team.TeamEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.team.TeamEntityNotFoundException;
import ru.akvine.prorise.repositories.TeamRepository;
import ru.akvine.prorise.service.dto.team.TeamBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
public class TeamService extends BaseService<TeamBean, TeamEntity> {
    public TeamService(UuidGenerator uuidGenerator, TeamRepository teamRepository) {
        super(uuidGenerator);
        this.teamRepository = teamRepository;
    }

    private final TeamRepository teamRepository;

    @Override
    protected BaseRepository<TeamEntity> getRepository() {
        return teamRepository;
    }

    @Override
    protected TeamEntity createEmptyEntity() {
        return new TeamEntity();
    }

    @Override
    protected TeamBean convertEntityToBean(TeamEntity entity) {
        return new TeamBean(entity);
    }

    @Override
    protected TeamEntity convertBeanToEntity(TeamBean bean, TeamEntity entity) {
        return entity
                .setDescription(bean.getDescription());
    }

    @Override
    protected TeamEntityNotFoundException createNotFoundException(String uuid) {
        return new TeamEntityNotFoundException(uuid);
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(TeamBean bean) {
        return new TeamEntityAlreadyFoundException(bean);
    }
}
