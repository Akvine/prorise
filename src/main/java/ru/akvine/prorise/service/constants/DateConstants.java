package ru.akvine.prorise.service.constants;


import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;


public class DateConstants {
    private DateConstants() {}

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd";
    public static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern(DATE_TIME_FORMAT)
            .parseDefaulting(ChronoField.ERA, 1)
            .toFormatter()
            .withChronology(IsoChronology.INSTANCE)
            .withResolverStyle(ResolverStyle.STRICT);


    public static final int UTC_UNIX_EPOCH_YEAR_START = 1970;
    public static final int UTC_UNIX_EPOCH_MONTH_START = 1;
    public static final int UTC_UNIX_EPOCH_DAY_OF_MONTH_START = 1;
    public static final int UTC_UNIX_EPOCH_HOUR_START = 0;
    public static final int UTC_UNIX_EPOCH_MINUTE_START = 0;
    public static final int UTC_UNIX_EPOCH_SECOND_START = 0;

}
