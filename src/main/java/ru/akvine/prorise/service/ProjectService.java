package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.entities.project.ProjectEntity;
import ru.akvine.prorise.entities.project.ProjectType;
import ru.akvine.prorise.exceptions.ProjectEntityNotFoundException;
import ru.akvine.prorise.repositories.ProjectRepository;
import ru.akvine.prorise.service.dto.project.ProjectBean;
import ru.akvine.prorise.utils.UuidGeneratorUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TeamService teamService;
    private final UuidGeneratorUtils uuidGeneratorUtils;

    @Value("${uuid.generator.length}")
    private int uuidGeneratorLength;
    @Value("{uuid.generator.target}")
    private String uuidGeneratorTarget;


    public ProjectBean getByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "Uuid is null");
        return new ProjectBean(getEntityByUuid(uuid));
    }

    public ProjectEntity getEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return projectRepository.findByUuidAndNotDeleted(uuid)
                .orElseThrow(() -> new ProjectEntityNotFoundException("ProjectEntity not found by uuid = " + uuid));
    }

    public List<ProjectBean> get() {
        return projectRepository
                .findAll()
                .stream()
                .map(ProjectBean::new)
                .collect(Collectors.toList());
    }

    public ProjectBean create(ProjectBean projectBean) {
        Preconditions.checkNotNull(projectBean, "projectBean is null");
        Preconditions.checkNotNull(projectBean.getTeamUuid(), "projectBean.teamUuid is null");

        TeamEntity teamEntity = teamService.getEntityByUuid(projectBean.getTeamUuid());
        ProjectEntity projectEntity = new ProjectEntity()
                .setUuid(uuidGeneratorUtils.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(projectBean.getTitle())
                .setDescription(projectBean.getDescription())
                .setTeam(teamEntity)
                .setType(projectBean.getProjectType())
                .setStartDate(projectBean.getStartDate())
                .setEndDate(projectBean.getEndDate());

        return new ProjectBean(projectRepository.save(projectEntity));
    }

    public ProjectBean update(ProjectBean projectBean) {
        Preconditions.checkNotNull(projectBean, "projectBean is null");
        ProjectEntity projectEntity = getEntityByUuid(projectBean.getUuid());

        String title = projectBean.getTitle();
        String description = projectBean.getDescription();
        LocalDate startDate = projectBean.getStartDate();
        LocalDate endDate = projectBean.getEndDate();
        boolean done = projectBean.isDone();
        ProjectType type = projectBean.getProjectType();
        String teamUuid = projectBean.getTeamUuid();

        if (StringUtils.isNotBlank(title)) {
            projectEntity.setTitle(title);
        }

        if (StringUtils.isNotBlank(description)) {
            projectEntity.setDescription(description);
        }

        if (startDate != null) {
            projectEntity.setStartDate(startDate);
        }

        if (endDate != null) {
            projectEntity.setEndDate(endDate);
        }

        if (type != null) {
            projectEntity.setType(type);
        }

        if (StringUtils.isNotBlank(teamUuid)) {
            TeamEntity teamEntity = teamService.getEntityByUuid(teamUuid);
            projectEntity.setTeam(teamEntity);
        }

        projectEntity
                .setDone(done)
                .setUpdatedDate(LocalDate.now());
        return new ProjectBean(projectRepository.save(projectEntity));
    }

    public void deleteByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        ProjectEntity projectEntity = getEntityByUuid(uuid);
        projectEntity.setDeleted(true);
        projectEntity.setDeletedDate(LocalDate.now());
        projectRepository.save(projectEntity);
    }
}
