package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.task.TaskEntity;
import ru.akvine.prorise.exceptions.TaskEntityNotFoundException;
import ru.akvine.prorise.repositories.TaskRepository;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.tech.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UuidGenerator uuidGenerator;

    @Value("${uuid.generator.length}")
    private int uuidGeneratorLength;
    @Value("{uuid.generator.target}")
    private String uuidGeneratorTarget;


    public TaskBean getByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "Uuid is null");
        return new TaskBean(getEntityByUuid(uuid));
    }

    public TaskEntity getEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return taskRepository.findByUuidAndNotDeleted(uuid)
                .orElseThrow(() -> new TaskEntityNotFoundException("TaskEntity not found by uuid = " + uuid));
    }

    public List<TaskBean> get() {
        return taskRepository
                .findAll()
                .stream()
                .map(TaskBean::new)
                .collect(Collectors.toList());
    }

    public TaskBean create(TaskBean taskBean) {
        Preconditions.checkNotNull(taskBean, "taskBean is null");

        TaskEntity taskEntity = new TaskEntity()
                .setUuid(uuidGenerator.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(taskBean.getTitle())
                .setDescription(taskBean.getDescription());

        return new TaskBean(taskRepository.save(taskEntity));
    }

    public TaskBean update(TaskBean taskBean) {
        Preconditions.checkNotNull(taskBean, "taskBean is null");
        TaskEntity taskEntity = getEntityByUuid(taskBean.getUuid());
        taskEntity
                .setTitle(taskBean.getTitle())
                .setDescription(taskBean.getDescription())
                .setDone(taskBean.isDone())
                .setStartDate(taskBean.getStartDate())
                .setEndDate(taskBean.getEndDate())
                .setUpdatedDate(LocalDate.now());

        return new TaskBean(taskRepository.save(taskEntity));
    }

    public void deleteByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        TaskEntity taskEntity = getEntityByUuid(uuid);
        taskEntity.setDeleted(true);
        taskEntity.setDeletedDate(LocalDate.now());
        taskRepository.save(taskEntity);
    }
}
