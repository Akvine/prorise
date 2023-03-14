package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.repositories.TaskRepository;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.task.TaskFilterResult;
import ru.akvine.prorise.service.dto.task.TaskFilterStart;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

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
