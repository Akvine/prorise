package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.entities.task.TaskEntity;
import ru.akvine.prorise.exceptions.TaskEntityNotFoundException;
import ru.akvine.prorise.exceptions.TeamEntityNotFoundException;
import ru.akvine.prorise.repositories.TeamRepository;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.team.TeamBean;
import ru.akvine.prorise.tech.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final UuidGenerator uuidGenerator;

    @Value("${uuid.generator.length}")
    private int uuidGeneratorLength;
    @Value("{uuid.generator.target}")
    private String uuidGeneratorTarget;


    public TeamBean getByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "Uuid is null");
        return new TeamBean(getEntityByUuid(uuid));
    }

    public TeamEntity getEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return teamRepository
                .findByUuidAndNotDeleted(uuid)
                .orElseThrow(() -> new TeamEntityNotFoundException("TeamEntity not found by uuid = " + uuid));
    }

    public List<TeamBean> get() {
        return teamRepository
                .findAll()
                .stream()
                .map(TeamBean::new)
                .collect(Collectors.toList());
    }

    public TeamBean create(TeamBean teamBean) {
        Preconditions.checkNotNull(teamBean, "teamBean is null");

        TeamEntity teamEntity = new TeamEntity()
                .setUuid(uuidGenerator.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(teamBean.getTitle())
                .setDescription(teamBean.getDescription());

        return new TeamBean(teamRepository.save(teamEntity));
    }

    public TeamBean update(TeamBean teamBean) {
        Preconditions.checkNotNull(teamBean, "teamBean is null");
        TeamEntity teamEntity = getEntityByUuid(teamBean.getUuid());
        teamEntity
                .setTitle(teamBean.getTitle())
                .setDescription(teamBean.getDescription())
                .setUpdatedDate(LocalDate.now());

        return new TeamBean(teamRepository.save(teamEntity));
    }

    public void deleteByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        TeamEntity teamEntity = getEntityByUuid(uuid);
        teamEntity.setDeleted(true);
        teamEntity.setDeletedDate(LocalDate.now());
        teamRepository.save(teamEntity);
    }
}
