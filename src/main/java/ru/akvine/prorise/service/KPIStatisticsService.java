package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.service.dto.attendance.AttendanceBean;
import ru.akvine.prorise.service.dto.attendance.AttendanceStatistics;
import ru.akvine.prorise.service.dto.task.TaskBean;
import ru.akvine.prorise.service.dto.task.TaskStatistics;
import ru.akvine.prorise.utils.DateUtils;
import ru.akvine.prorise.utils.MathUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KPIStatisticsService {
    private final DateUtils dateUtils;
    private final MathUtils mathUtils;

    public AttendanceStatistics calculateAttendanceStatistics(List<AttendanceBean> attendances) {
        Preconditions.checkNotNull(attendances, "attendances is null");
        List<LocalDateTime> arrivalDates = attendances.stream().map(AttendanceBean::getArrivalDate).collect(Collectors.toList());
        List<LocalDateTime> departureDates = attendances.stream().map(AttendanceBean::getDepartureTime).collect(Collectors.toList());

        LocalDateTime averageArrivalTime = dateUtils.calculateAverageTime(arrivalDates);
        LocalDateTime averageDepartureTime = dateUtils.calculateAverageTime(departureDates);
        LocalDateTime averageWorkTime = dateUtils.calculateAverageTime(dateUtils.calculateDifference(arrivalDates, departureDates));

        return new AttendanceStatistics(averageArrivalTime, averageDepartureTime, averageWorkTime);
    }

    public TaskStatistics calculateTaskStatistics(List<TaskBean> completedTasks, List<TaskBean> allTasks) {
        Preconditions.checkNotNull(completedTasks, "tasks is null");
        List<LocalDateTime> startDates = completedTasks.stream().map(TaskBean::getStartDate).collect(Collectors.toList());
        List<LocalDateTime> endDates = completedTasks.stream().map(TaskBean::getEndDate).collect(Collectors.toList());

        List<LocalDateTime> tasksCompletionsTimes = dateUtils.calculateDifference(startDates, endDates);

        long completedTasksCount = completedTasks.size();
        long allTasksCount = allTasks.size();
        double effectiveness = mathUtils.round(completedTasksCount / allTasksCount, 3);
        LocalDateTime averageTaskCompletionTime = dateUtils.calculateAverageTime(tasksCompletionsTimes);
        LocalDateTime maxTaskCompletionTime = dateUtils.findMaxDateTime(tasksCompletionsTimes);
        LocalDateTime minTaskCompletionTime = dateUtils.findMinDateTime(tasksCompletionsTimes);

        return new TaskStatistics(
                completedTasksCount,
                effectiveness,
                averageTaskCompletionTime,
                maxTaskCompletionTime,
                minTaskCompletionTime);
    }
}
