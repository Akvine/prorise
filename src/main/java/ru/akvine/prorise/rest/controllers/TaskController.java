package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.BaseConverter;
import ru.akvine.prorise.rest.converter.TaskConverter;
import ru.akvine.prorise.rest.dto.task.TaskDto;
import ru.akvine.prorise.rest.validator.BaseValidator;
import ru.akvine.prorise.rest.validator.TaskValidator;
import ru.akvine.prorise.service.BaseService;
import ru.akvine.prorise.service.TaskService;
import ru.akvine.prorise.service.dto.task.TaskBean;

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
}
