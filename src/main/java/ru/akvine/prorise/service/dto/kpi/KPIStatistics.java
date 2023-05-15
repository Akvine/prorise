package ru.akvine.prorise.service.dto.kpi;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.akvine.prorise.service.dto.attendance.AttendanceStatistics;
import ru.akvine.prorise.service.dto.task.TaskStatistics;

@Getter
@Setter
@Accessors(chain = true)
public class KPIStatistics {
    private AttendanceStatistics attendanceStatistics;
    private TaskStatistics taskStatistics;
}
