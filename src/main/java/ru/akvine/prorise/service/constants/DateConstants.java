package ru.akvine.prorise.service.constants;


import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;


public class DateConstants {
    private DateConstants() {}

    public static final String LOCAL_DATE_FORMAT = "yyyy-MM-dd";
    public static final String LOCAL_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final DateTimeFormatter LOCAL_DATE_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern(LOCAL_DATE_FORMAT)
            .parseDefaulting(ChronoField.ERA, 1)
            .toFormatter()
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);
    public static final DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_FORMAT);


    public static final int UTC_UNIX_EPOCH_YEAR_START = 1970;
    public static final int UTC_UNIX_EPOCH_MONTH_START = 1;
    public static final int UTC_UNIX_EPOCH_DAY_OF_MONTH_START = 1;
    public static final int UTC_UNIX_EPOCH_HOUR_START = 0;
    public static final int UTC_UNIX_EPOCH_MINUTE_START = 0;
    public static final int UTC_UNIX_EPOCH_SECOND_START = 0;

    public static final int CENTURY = 100;

}
