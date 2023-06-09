package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.entities.employer.EmployerEntity;
import ru.akvine.prorise.entities.task.PriorityType;
import ru.akvine.prorise.entities.task.StatusType;
import ru.akvine.prorise.entities.task.TaskEntity;
import ru.akvine.prorise.exceptions.TaskEntityNotFoundException;
import ru.akvine.prorise.repositories.TaskRepository;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.utils.UuidGeneratorUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final EmployerService employerService;
    private final GoalService goalService;
    private final UuidGeneratorUtils uuidGeneratorUtils;

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
        Preconditions.checkNotNull(taskBean.getEmployerUuid(), "taskBean.goalUuid is null");
        Preconditions.checkNotNull(taskBean.getGoalUuid(), "taskBean.goalUuid is null");

        EmployerEntity employerEntity = employerService.getEntityByUuid(taskBean.getEmployerUuid());
        GoalEntity goalEntity = goalService.getEntityByUuid(taskBean.getGoalUuid());

        TaskEntity taskEntity = new TaskEntity()
                .setUuid(uuidGeneratorUtils.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(taskBean.getTitle())
                .setDescription(taskBean.getDescription())
                .setDone(taskBean.isDone())
                .setPriority(taskBean.getPriorityType())
                .setStatus(taskBean.getStatusType())
                .setStartDate(taskBean.getStartDate())
                .setEndDate(taskBean.getEndDate())
                .setEmployer(employerEntity)
                .setGoal(goalEntity);

        return new TaskBean(taskRepository.save(taskEntity));
    }

    public TaskBean update(TaskBean taskBean) {
        Preconditions.checkNotNull(taskBean, "taskBean is null");
        TaskEntity taskEntity = getEntityByUuid(taskBean.getUuid());

        String title = taskBean.getTitle();
        String description = taskBean.getDescription();
        PriorityType priority = taskBean.getPriorityType();
        StatusType status = taskBean.getStatusType();
        LocalDateTime startDate = taskBean.getStartDate();
        LocalDateTime endDate = taskBean.getEndDate();

        if (StringUtils.isNotBlank(title)) {
            taskEntity.setTitle(title);
        }
        if (StringUtils.isNotBlank(description)) {
            taskEntity.setDescription(description);
        }
        if (priority != null) {
            taskEntity.setPriority(priority);
        }
        if (status != null) {
            taskEntity.setStatus(status);
        }
        if (startDate != null) {
            taskEntity.setStartDate(startDate);
        }
        if (endDate != null) {
            taskEntity.setEndDate(endDate);
        }

        String employerUuid = taskBean.getEmployerUuid();
        String goalUuid = taskBean.getGoalUuid();
        if (StringUtils.isNotBlank(employerUuid)) {
            EmployerEntity employerEntity = employerService.getEntityByUuid(employerUuid);
            taskEntity.setEmployer(employerEntity);
        }
        if (StringUtils.isNotBlank(goalUuid)) {
            GoalEntity goalEntity = goalService.getEntityByUuid(goalUuid);
            taskEntity.setGoal(goalEntity);
        }

        taskEntity
                .setDone(taskBean.isDone())
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

    public List<TaskBean> getCompletedTask() {
        return taskRepository
                .findByCompleted()
                .stream()
                .map(TaskBean::new)
                .collect(Collectors.toList());
    }
}
