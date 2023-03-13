package ru.akvine.prorise.service.dto.goal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.service.dto.BaseBean;
import ru.akvine.prorise.service.dto.task.TaskBean;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class GoalBean extends BaseBean<Long> {
    private String description;
    private List<TaskBean> tasks;
    private boolean done;

    public GoalBean(GoalEntity entity) {
        super(entity);
        this.done = entity.isDone();
        this.description = entity.getDescription();
        this.tasks = entity
                .getTasks()
                .stream()
                .map(TaskBean::new)
                .collect(Collectors.toList());
    }
}
