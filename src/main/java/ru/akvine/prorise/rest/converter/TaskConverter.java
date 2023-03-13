package ru.akvine.prorise.rest.converter;

import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.task.TaskDto;
import ru.akvine.prorise.service.dto.task.TaskBean;

@Component
public class TaskConverter extends BaseConverter<TaskDto, TaskBean> {
    @Override
    protected TaskDto convertBeanToDto(TaskBean bean) {
        return null;
    }

    @Override
    protected TaskBean convertDtoToBean(TaskDto dto) {
        return null;
    }

    @Override
    protected TaskBean createEmptyBean() {
        return null;
    }
}
