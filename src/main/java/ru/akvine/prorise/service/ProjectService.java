package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import liquibase.hub.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.entities.project.ProjectEntity;
import ru.akvine.prorise.exceptions.GoalEntityNotFoundException;
import ru.akvine.prorise.exceptions.ProjectEntityNotFoundException;
import ru.akvine.prorise.repositories.ProjectRepository;
import ru.akvine.prorise.service.dto.goal.GoalBean;
import ru.akvine.prorise.service.dto.project.ProjectBean;
import ru.akvine.prorise.tech.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UuidGenerator uuidGenerator;

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

        ProjectEntity projectEntity = new ProjectEntity()
                .setUuid(uuidGenerator.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(projectBean.getTitle())
                .setDescription(projectBean.getDescription());

        return new ProjectBean(projectRepository.save(projectEntity));
    }

    public ProjectBean update(ProjectBean projectBean) {
        Preconditions.checkNotNull(projectBean, "projectBean is null");
        ProjectEntity projectEntity = getEntityByUuid(projectBean.getUuid());
        projectEntity
                .setTitle(projectBean.getTitle())
                .setDescription(projectBean.getDescription())
                .setDone(projectBean.isDone())
                .setStartedDate(projectBean.getStartDate())
                .setEndDate(projectBean.getEndDate())
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
