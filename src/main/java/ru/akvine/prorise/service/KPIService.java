package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.repositories.AttendanceRepository;
import ru.akvine.prorise.repositories.EmployerRepository;
import ru.akvine.prorise.repositories.TaskRepository;
import ru.akvine.prorise.service.dto.attendance.AttendanceBean;
import ru.akvine.prorise.service.dto.attendance.AttendanceStatistics;
import ru.akvine.prorise.service.dto.employer.EmployerBean;
import ru.akvine.prorise.service.dto.kpi.KPIStatistics;
import ru.akvine.prorise.service.dto.kpi.KPIStatisticsFilter;
import ru.akvine.prorise.service.dto.kpi.filter.FilterType;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.task.TaskStatistics;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KPIService {
    private final EmployerRepository employerRepository;
    private final TaskRepository taskRepository;
    private final AttendanceRepository attendanceRepository;
    private final KPIStatisticsService kpiStatisticsService;

    public KPIStatistics getKPI(KPIStatisticsFilter kpiStatisticsFilter) {
        Preconditions.checkNotNull(kpiStatisticsFilter, "kpiStatisticsFilter is null");

        FilterType filterType = kpiStatisticsFilter.getFilterType();
        List<EmployerBean> employers;
        if (filterType == FilterType.DEPARTMENT) {
            String title = kpiStatisticsFilter.getDepartmentFilter().getTitle();
            String type = kpiStatisticsFilter.getDepartmentFilter().getType();
            employers = employerRepository
                    .findByDepartmentTitleOrType(title, type)
                    .stream()
                    .map(EmployerBean::new)
                    .collect(Collectors.toList());
        } else if (filterType == FilterType.TEAM) {
            String title = kpiStatisticsFilter.getTeamFilter().getTitle();
            employers = employerRepository
                    .findByTeamTitle(title)
                    .stream()
                    .map(EmployerBean::new)
                    .collect(Collectors.toList());
        } else {
            String uuid = kpiStatisticsFilter.getEmployerFilter().getUuid();
            String firstName = kpiStatisticsFilter.getEmployerFilter().getFirstName();
            String secondName = kpiStatisticsFilter.getEmployerFilter().getSecondName();
            String thirdName = kpiStatisticsFilter.getEmployerFilter().getThirdName();
            employers = employerRepository
                    .findByUuidOrFirstNameOrSecondNameOrThirdName(uuid, firstName, secondName, thirdName)
                    .stream()
                    .map(EmployerBean::new)
                    .collect(Collectors.toList());
        }

        Set<String> employersUuids = employers
                .stream()
                .map(EmployerBean::getUuid)
                .collect(Collectors.toSet());
        List<TaskBean> completedTasks = taskRepository
                .findAllCompletedByEmployersUuids(employersUuids)
                .stream()
                .map(TaskBean::new)
                .collect(Collectors.toList());
        List<TaskBean> allTasks = taskRepository
                .findAllByEmployersUuids(employersUuids)
                .stream()
                .map(TaskBean::new)
                .collect(Collectors.toList());
        List<AttendanceBean> attendances = attendanceRepository
                .findByEmployersUuids(employersUuids)
                .stream()
                .map(AttendanceBean::new)
                .collect(Collectors.toList());

        AttendanceStatistics attendanceStatistics = kpiStatisticsService.calculateAttendanceStatistics(attendances);
        TaskStatistics taskStatistics = kpiStatisticsService.calculateTaskStatistics(completedTasks, allTasks);

        return new KPIStatistics()
                .setAttendanceStatistics(attendanceStatistics)
                .setTaskStatistics(taskStatistics);
    }
}
