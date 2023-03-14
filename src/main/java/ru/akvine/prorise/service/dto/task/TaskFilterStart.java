package ru.akvine.prorise.service.dto.task;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class TaskFilterStart {
    @Nullable
    private LocalDate startDate;
    @Nullable
    private LocalDate endDate;
    @Nullable
    private String employerUuid;
}
