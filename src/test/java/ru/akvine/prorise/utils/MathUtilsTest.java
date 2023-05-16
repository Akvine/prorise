package ru.akvine.prorise.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;

@DisplayName("MathHelperTest")
@ExtendWith(MockitoExtension.class)
class MathUtilsTest {
    @InjectMocks
    private MathUtils mathUtils;

    @Test
    @DisplayName("Round case 1")
    void round_case_1() {
        double startValue = 100.2681937;
        double expected = 100.268;
        double result = mathUtils.round(startValue, 3);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Round case 2")
    void round_case_2() {
        double startValue = -50.139;
        double expected = -50.14;
        double result = mathUtils.round(startValue, 2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Round case 3")
    void round_case_3() {
        double startValue = 25.555;
        double expected = 25.56;
        double result = mathUtils.round(startValue, 2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Round case 4")
    void round_case_4() {
        double startValue = 98.56;
        double expected = 98.56;
        double result = mathUtils.round(startValue, 9);

        assertThat(result).isEqualTo(expected);
    }
}