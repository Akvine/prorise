package ru.akvine.prorise.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static ru.akvine.prorise.service.constants.DateConstants.*;

@Service
@RequiredArgsConstructor
public class DateService {
    @Nullable
    public LocalDate toLocalDate(String date) {
        if (date == null) {
            return null;
        }
        return toLocalDate(date, FORMATTER);
    }

    @Nullable
    public LocalDate toLocalDate(String date, DateTimeFormatter formatter) {
        if (date == null) {
            return null;
        }
        return LocalDate.parse(date, formatter);
    }

    public LocalDateTime calculateAverageTime(List<LocalDateTime> dates) {
        long totalSeconds = dates
                .stream()
                .mapToLong(date -> date.toLocalTime().toSecondOfDay())
                .sum();

        return LocalDateTime.of(
                UTC_UNIX_EPOCH_YEAR_START,
                UTC_UNIX_EPOCH_MONTH_START,
                UTC_UNIX_EPOCH_DAY_OF_MONTH_START,
                UTC_UNIX_EPOCH_HOUR_START,
                UTC_UNIX_EPOCH_MINUTE_START,
                UTC_UNIX_EPOCH_SECOND_START)
                .plusSeconds(totalSeconds / dates.size());
    }

    public List<LocalDateTime> calculateDifference(List<LocalDateTime> startDates, List<LocalDateTime> endDates) {
        List<LocalDateTime> differences = new ArrayList<>();

        for (int i = 0; i < startDates.size() && i < endDates.size(); i++) {
            LocalDateTime startDate = startDates.get(i);
            LocalDateTime endDate = endDates.get(i);
            Duration duration = Duration.between(startDate, endDate);
            LocalDateTime difference = startDate.plus(duration);
            differences.add(difference);
        }

        return differences;
    }
}
