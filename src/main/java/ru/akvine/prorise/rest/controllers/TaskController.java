package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.TaskConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.task.TaskDto;
import ru.akvine.prorise.rest.dto.task.TaskFilterRequest;
import ru.akvine.prorise.rest.validator.TaskValidator;
import ru.akvine.prorise.service.TaskService;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.task.TaskFilterResult;
import ru.akvine.prorise.service.dto.task.TaskFilterStart;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/tasks")
public class TaskController extends BaseController<TaskDto, TaskBean> {
    private final TaskValidator taskValidator;
    private final TaskService taskService;
    private final TaskConverter taskConverter;

    @Override
    protected BaseValidator getValidator() {
        return taskValidator;
    }

    @Override
    protected BaseConverter getConverter() {
        return taskConverter;
    }

    @Override
    protected BaseService getService() {
        return taskService;
    }

    @GetMapping("/completed")
    public Response getCompletedTasks(@Valid @RequestBody TaskFilterRequest request) {
        TaskFilterStart taskFilterStart = taskConverter.convertToTaskFilterStart(request);
        TaskFilterResult taskFilterResult = taskService.getCompletedTasksByFilter(taskFilterStart);
        return taskConverter.convertToTaskFilterResponse(taskFilterResult);
    }
}
