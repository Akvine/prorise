package ru.akvine.prorise.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static ru.akvine.prorise.service.constants.DateConstants.*;
import static org.assertj.core.api.Assertions.*;

@DisplayName("DateServiceTest")
@ExtendWith(MockitoExtension.class)
class DateUtilsTest {

    @InjectMocks
    private DateUtils dateUtils;

    @Test
    @DisplayName("Calculate average time - Return UNIX Epoch start date if dates is empty")
    void calculateAverageTime_return_unix_epoch_start_date_if_isEmpty() {
        LocalDateTime result = dateUtils.calculateAverageTime(List.of());

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(UNIX_EPOCH_TIME);
    }

    @Test
    @DisplayName("Calculate average time - Throw Exception if dates is null")
    void calculateAverageTime_throw_exception_if_null() {
        assertThatThrownBy(() -> dateUtils.calculateAverageTime(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("dates is null");
    }

    @Test
    @DisplayName("Calculate average time - return average time case 1")
    void calculateAverageTime_return_average_value_case_1() {
        List<LocalDateTime> dates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dates.add(UNIX_EPOCH_TIME.plusHours(8));
        }
        LocalDateTime expected = LocalDateTime.of(
                UTC_UNIX_EPOCH_YEAR_START,
                UTC_UNIX_EPOCH_MONTH_START,
                UTC_UNIX_EPOCH_DAY_START,
                8,
                UTC_UNIX_EPOCH_MINUTE_START,
                UTC_UNIX_EPOCH_SECOND_START);
        LocalDateTime result = dateUtils.calculateAverageTime(dates);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(expected);
    }
}