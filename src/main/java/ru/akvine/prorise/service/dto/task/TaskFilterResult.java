package ru.akvine.prorise.service.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class TaskFilterResult {
    private int count;
    private List<TaskBean> tasks;
}
