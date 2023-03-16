package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.TaskControllerMeta;
import ru.akvine.prorise.rest.converter.TaskConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.dto.task.TaskCreateRequest;
import ru.akvine.prorise.rest.dto.task.TaskUpdateRequest;
import ru.akvine.prorise.rest.validator.TaskValidator;
import ru.akvine.prorise.service.TaskService;
import ru.akvine.prorise.service.dto.task.TaskBean;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks")
public class TaskController implements TaskControllerMeta {
    private final TaskValidator taskValidator;
    private final TaskService taskService;
    private final TaskConverter taskConverter;

    @Override
    public Response get() {
        List<TaskBean> tasks = taskService.get();
        return taskConverter.convertToTaskListResponse(tasks);
    }

    @Override
    public Response getByUuid(String uuid) {
        TaskBean taskBean = taskService.getByUuid(uuid);
        return taskConverter.convertToTaskResponse(taskBean);
    }

    @Override
    public Response create(TaskCreateRequest request) {
        TaskBean taskBean = taskConverter.convertToTaskBean(request);
        TaskBean createdBean = taskService.create(taskBean);
        return taskConverter.convertToTaskResponse(createdBean);
    }

    @Override
    public Response update(TaskUpdateRequest request) {
        TaskBean taskBean = taskConverter.convertToTaskBean(request);
        TaskBean updatedBean = taskService.update(taskBean);
        return taskConverter.convertToTaskResponse(updatedBean);
    }

    @Override
    public Response deleteByUuid(String uuid) {
        taskService.deleteByUuid(uuid);
        return new SuccessfulResponse();
    }
}
