package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.entities.department.DepartmentEntity;
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
    private final DepartmentService departmentService;
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
        Preconditions.checkNotNull(teamBean.getDepartmentUuid(), "teamBean.departmentUuid is null");

        DepartmentEntity departmentEntity = departmentService.getEntityByUuid(teamBean.getDepartmentUuid());

        TeamEntity teamEntity = new TeamEntity()
                .setUuid(uuidGenerator.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(teamBean.getTitle())
                .setDescription(teamBean.getDescription())
                .setDepartmentEntity(departmentEntity);

        return new TeamBean(teamRepository.save(teamEntity));
    }

    public TeamBean update(TeamBean teamBean) {
        Preconditions.checkNotNull(teamBean, "teamBean is null");

        TeamEntity teamEntity = getEntityByUuid(teamBean.getUuid());
        teamEntity
                .setTitle(teamBean.getTitle())
                .setDescription(teamBean.getDescription())
                .setUpdatedDate(LocalDate.now());

        String departmentUuid = teamBean.getDepartmentUuid();

        if (StringUtils.isNotBlank(departmentUuid)) {
            DepartmentEntity departmentEntity = departmentService.getEntityByUuid(departmentUuid);
            teamEntity.setDepartmentEntity(departmentEntity);
        }

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
