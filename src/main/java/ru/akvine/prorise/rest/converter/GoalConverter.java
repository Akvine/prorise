package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.goal.GoalDto;
import ru.akvine.prorise.rest.dto.task.TaskDto;
import ru.akvine.prorise.service.dto.goal.GoalBean;
import ru.akvine.prorise.service.dto.task.TaskBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GoalConverter extends BaseConverter<GoalDto, GoalBean> {
    @Override
    protected GoalDto convertBeanToDto(GoalBean goalBean) {
        Preconditions.checkNotNull(goalBean, "goalBean is null");
        List<TaskDto> tasks = goalBean
                .getTasks()
                .stream()
                .map(this::buildTaskDto)
                .collect(Collectors.toList());
        return new GoalDto()
                .setDescription(goalBean.getDescription())
                .setDone(goalBean.isDone())
                .setTasks(tasks);
    }

    @Override
    protected GoalBean convertDtoToBean(GoalDto goalDto) {
        Preconditions.checkNotNull(goalDto, "goalDto is null");
        return new GoalBean()
                .setDescription(goalDto.getDescription())
                .setDone(goalDto.isDone());
    }

    @Override
    protected GoalBean createEmptyBean() {
        return new GoalBean();
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
