package ru.akvine.prorise.tech;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;

@Component
public class DateConverter {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd";
    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern(DATE_TIME_FORMAT)
            .parseDefaulting(ChronoField.ERA, 1)
            .toFormatter()
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);

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
}
