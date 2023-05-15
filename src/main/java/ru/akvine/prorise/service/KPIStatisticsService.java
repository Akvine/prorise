package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.service.dto.attendance.AttendanceBean;
import ru.akvine.prorise.service.dto.attendance.AttendanceTimeStatistics;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KPIStatisticsService {
    private final DateService dateService;

    public AttendanceTimeStatistics calculateAverageArrivalTime(List<AttendanceBean> attendanceBeans) {
        Preconditions.checkNotNull(attendanceBeans, "attendanceBeans is null");
        List<LocalDateTime> arrivalDates = attendanceBeans.stream().map(AttendanceBean::getArrivalDate).collect(Collectors.toList());
        List<LocalDateTime> departureDates = attendanceBeans.stream().map(AttendanceBean::getDepartureTime).collect(Collectors.toList());

        LocalDateTime averageArrivalTime = dateService.calculateAverageTime(arrivalDates);
        LocalDateTime averageDepartureTime = dateService.calculateAverageTime(departureDates);
        LocalDateTime averageWorkTime = dateService.calculateAverageTime(dateService.calculateDifference(arrivalDates, departureDates));

        return new AttendanceTimeStatistics(averageArrivalTime, averageDepartureTime, averageWorkTime);
    }
}
