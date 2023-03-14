package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.task.TaskEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.exceptions.task.TaskEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.task.TaskEntityNotFoundException;
import ru.akvine.prorise.repositories.BaseRepository;
import ru.akvine.prorise.repositories.TaskRepository;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.task.TaskFilterResult;
import ru.akvine.prorise.service.dto.task.TaskFilterStart;
import ru.akvine.prorise.tech.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService extends BaseService<TaskBean, TaskEntity> {
    private final TaskRepository taskRepository;

    public TaskService(UuidGenerator uuidGenerator, TaskRepository taskRepository) {
        super(uuidGenerator);
        this.taskRepository = taskRepository;
    }

    @Override
    protected BaseRepository<TaskEntity> getRepository() {
        return taskRepository;
    }

    @Override
    protected TaskEntity createEmptyEntity() {
        return new TaskEntity();
    }

    @Override
    protected TaskBean convertEntityToBean(TaskEntity entity) {
        return new TaskBean(entity);
    }

    @Override
    protected TaskEntity convertBeanToEntity(TaskBean bean, TaskEntity entity) {
        return entity
                .setDescription(bean.getDescription())
                .setTitle(bean.getTitle())
                .setStartedDate(bean.getStartDate())
                .setEndDate(bean.getEndDate())
                .setEmployer(entity.getEmployer())
                .setStatus(bean.getStatusType())
                .setPriority(bean.getPriorityType())
                .setDone(bean.isDone());
    }

    @Override
    protected BaseEntityNotFoundException createNotFoundException(String uuid) {
        return new TaskEntityNotFoundException(uuid);
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(TaskBean bean) {
        return new TaskEntityAlreadyFoundException(bean);
    }

    public TaskFilterResult getCompletedTasksByFilter(TaskFilterStart taskFilterStart) {
        Preconditions.checkNotNull(taskFilterStart, "taskFilterStart is null");

        LocalDate startDate = taskFilterStart.getStartDate();
        LocalDate endDate = taskFilterStart.getEndDate();
        String employerUuid = taskFilterStart.getEmployerUuid();

        List<TaskBean> tasks;
        if (startDate != null && endDate != null && StringUtils.isNotBlank(employerUuid)) {
            tasks = taskRepository
                    .getCompletedByPeriodDateAndEmployerUuid(startDate, endDate, employerUuid)
                    .stream()
                    .map(TaskBean::new)
                    .collect(Collectors.toList());
        } else if (startDate != null && endDate != null) {
            tasks = taskRepository
                    .getCompletedByPeriodDate(startDate, endDate)
                    .stream()
                    .map(TaskBean::new)
                    .collect(Collectors.toList());
        } else {
            tasks = taskRepository
                    .getCompleted()
                    .stream()
                    .map(TaskBean::new)
                    .collect(Collectors.toList());
        }

        return new TaskFilterResult()
                .setTasks(tasks)
                .setCount(tasks.size());
    }
}
