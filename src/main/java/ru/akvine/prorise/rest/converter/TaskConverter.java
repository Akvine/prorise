package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.task.TaskDto;
import ru.akvine.prorise.rest.dto.task.TaskFilterRequest;
import ru.akvine.prorise.rest.dto.task.TaskFilterResponse;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.task.TaskFilterResult;
import ru.akvine.prorise.service.dto.task.TaskFilterStart;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskConverter extends BaseConverter<TaskDto, TaskBean> {
    @Override
    protected TaskDto convertBeanToDto(TaskBean taskBean) {
        Preconditions.checkNotNull(taskBean, "taskBean is null");
        return new TaskDto()
                .setTitle(taskBean.getTitle())
                .setDescription(taskBean.getDescription())
                .setStartDate(taskBean.getStartDate())
                .setEndDate(taskBean.getEndDate())
                .setEmployerUuid(taskBean.getEmployer().getUuid())
                .setStatus(taskBean.getStatusType().name())
                .setPriority(taskBean.getPriorityType().name());
    }

    @Override
    protected TaskBean convertDtoToBean(TaskDto taskDto) {
        Preconditions.checkNotNull(taskDto, "taskDto is null");
        return new TaskBean()
                .setTitle(taskDto.getTitle())
                .setDescription(taskDto.getDescription())
                .setStartDate(taskDto.getStartDate())
                .setEndDate(taskDto.getEndDate());
    }

    @Override
    protected TaskBean createEmptyBean() {
        return new TaskBean();
    }

    public TaskFilterStart convertToTaskFilterStart(TaskFilterRequest request) {
        Preconditions.checkNotNull(request, "taskFilterRequest is null");
        return new TaskFilterStart()
                .setStartDate(request.getStartDate())
                .setEndDate(request.getEndDate())
                .setEmployerUuid(request.getEmployerUuid());
    }

    public TaskFilterResponse convertToTaskFilterResponse(TaskFilterResult result) {
        Preconditions.checkNotNull(result, "taskFilterResult is null");
        List<TaskDto> tasks = result
                .getTasks()
                .stream()
                .map(this::buildTaskDto)
                .collect(Collectors.toList());
        return new TaskFilterResponse()
                .setCount(result.getCount())
                .setTasks(tasks);
    }

    private TaskDto buildTaskDto(TaskBean taskBean) {
        return new TaskDto()
                .setTitle(taskBean.getTitle())
                .setDescription(taskBean.getDescription())
                .setStartDate(taskBean.getStartDate())
                .setEndDate(taskBean.getEndDate())
                .setStatus(taskBean.getStatusType().name())
                .setPriority(taskBean.getPriorityType().name())
                .setEmployerUuid(taskBean.getEmployer().getUuid())
                .setDone(taskBean.isDone());
    }
}
