package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.task.PriorityType;
import ru.akvine.prorise.entities.task.StatusType;
import ru.akvine.prorise.rest.dto.task.TaskCreateRequest;
import ru.akvine.prorise.rest.dto.task.TaskListResponse;
import ru.akvine.prorise.rest.dto.task.TaskResponse;
import ru.akvine.prorise.rest.dto.task.TaskUpdateRequest;
import ru.akvine.prorise.service.dto.task.TaskBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskConverter {
    public TaskBean convertToTaskBean(TaskCreateRequest request) {
        Preconditions.checkNotNull(request, "taskCreateRequest is null");
        Preconditions.checkNotNull(request, "taskUpdateRequest is null");
        return new TaskBean()
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setPriorityType(PriorityType.safeValueOf(request.getPriority()))
                .setStatusType(StatusType.safeValueOf(request.getStatus()))
                .setEmployerUuid(request.getEmployerUuid())
                .setDone(request.isDone())
                .setEmployerUuid(request.getGoalUuid());
    }

    public TaskBean convertToTaskBean(TaskUpdateRequest request) {
        Preconditions.checkNotNull(request, "taskUpdateRequest is null");
        return new TaskBean()
                .setUuid(request.getUuid())
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setPriorityType(PriorityType.safeValueOf(request.getPriority()))
                .setStatusType(StatusType.safeValueOf(request.getStatus()))
                .setEmployerUuid(request.getEmployerUuid())
                .setDone(request.isDone())
                .setGoalUuid(request.getGoalUuid());
    }

    public TaskResponse convertToTaskResponse(TaskBean taskBean) {
        Preconditions.checkNotNull(taskBean, "taskBean is null");
        return new TaskResponse()
                .setTitle(taskBean.getTitle())
                .setDescription(taskBean.getDescription())
                .setEmployerUuid(taskBean.getEmployerBean().getUuid())
                .setStartDate(taskBean.getStartDate())
                .setEndDate(taskBean.getEndDate())
                .setDone(taskBean.isDone())
                .setPriority(taskBean.getPriorityType().name())
                .setStatus(taskBean.getStatusType().name());
    }

    public TaskListResponse convertToTaskListResponse(List<TaskBean> tasks) {
        Preconditions.checkNotNull(tasks, "tasks is null");
        List<TaskResponse> taskBeans = tasks
                .stream()
                .map(this::convertToTaskResponse)
                .collect(Collectors.toList());
        return new TaskListResponse()
                .setTasks(taskBeans);
    }
}
