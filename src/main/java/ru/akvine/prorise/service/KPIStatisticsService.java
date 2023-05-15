package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.service.dto.attendance.AttendanceBean;
import ru.akvine.prorise.service.dto.attendance.AttendanceStatistics;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.task.TaskStatistics;
import ru.akvine.prorise.tech.MathHelper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KPIStatisticsService {
    private final DateService dateService;
    private final MathHelper mathHelper;

    public AttendanceStatistics calculateAttendanceStatistics(List<AttendanceBean> attendances) {
        Preconditions.checkNotNull(attendances, "attendances is null");
        List<LocalDateTime> arrivalDates = attendances.stream().map(AttendanceBean::getArrivalDate).collect(Collectors.toList());
        List<LocalDateTime> departureDates = attendances.stream().map(AttendanceBean::getDepartureTime).collect(Collectors.toList());

        LocalDateTime averageArrivalTime = dateService.calculateAverageTime(arrivalDates);
        LocalDateTime averageDepartureTime = dateService.calculateAverageTime(departureDates);
        LocalDateTime averageWorkTime = dateService.calculateAverageTime(dateService.calculateDifference(arrivalDates, departureDates));

        return new AttendanceStatistics(averageArrivalTime, averageDepartureTime, averageWorkTime);
    }

    public TaskStatistics calculateTaskStatistics(List<TaskBean> completedTasks, List<TaskBean> allTasks) {
        Preconditions.checkNotNull(completedTasks, "tasks is null");
        List<LocalDateTime> startDates = completedTasks.stream().map(TaskBean::getStartDate).collect(Collectors.toList());
        List<LocalDateTime> endDates = completedTasks.stream().map(TaskBean::getEndDate).collect(Collectors.toList());

        List<LocalDateTime> tasksCompletionsTimes = dateService.calculateDifference(startDates, endDates);

        long completedTasksCount = completedTasks.size();
        long allTasksCount = allTasks.size();
        double effectiveness = mathHelper.round(completedTasksCount / allTasksCount, 3);
        LocalDateTime averageTaskCompletionTime = dateService.calculateAverageTime(tasksCompletionsTimes);
        LocalDateTime maxTaskCompletionTime = dateService.findMaxDateTime(tasksCompletionsTimes);
        LocalDateTime minTaskCompletionTime = dateService.findMinDateTime(tasksCompletionsTimes);

        return new TaskStatistics(
                completedTasksCount,
                effectiveness,
                averageTaskCompletionTime,
                maxTaskCompletionTime,
                minTaskCompletionTime);
    }
}
