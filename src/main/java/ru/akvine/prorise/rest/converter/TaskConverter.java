package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.task.TaskDto;
import ru.akvine.prorise.service.dto.task.TaskBean;

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
}
