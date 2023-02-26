package ru.akvine.prorise.tech;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("UuidGenerator")
@ExtendWith(MockitoExtension.class)
class UuidGeneratorTest {
    private static final String VALIDATION_EXCEPTION_MESSAGE = "Length can't be less -1 or more than generated uuid";

    @InjectMocks
    private UuidGenerator uuidGenerator;

    @Test
    void generate() {
        String uuid = uuidGenerator.generate();
        assertThat(uuid).isNotBlank();
    }

    @Test
    void generate_length_case1() {
        int length = 25;
        String uuid = uuidGenerator.generate(length);

        assertThat(uuid).isNotBlank();
        assertThat(uuid.length()).isEqualTo(length);
    }

    @Test
    void generate_length_case2() {
        int length = 10;
        int wrongLength = 20;
        String uuid = uuidGenerator.generate(length);

        assertThat(uuid).isNotBlank();
        assertThat(uuid.length()).isNotEqualTo(wrongLength);
        assertThat(uuid.length()).isEqualTo(length);
    }

    @Test
    void generate_length_invalid_case3() {
        int invalidLength = -10;
        assertThatThrownBy(() -> uuidGenerator.generate(invalidLength))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(VALIDATION_EXCEPTION_MESSAGE);
    }

    @Test
    void generate_length_target_case1() {
        int length = 10;
        String replaceTarget = "-";
        String uuid = uuidGenerator.generate(length, replaceTarget);

        assertThat(uuid).isNotBlank();
        assertThat(uuid.contains(replaceTarget)).isFalse();
    }

    @Test
    void generate_length_target_case2() {
        int length = 25;
        String replaceTarget = "-";
        String uuid = uuidGenerator.generate(length, replaceTarget);

        assertThat(uuid).isNotBlank();
        assertThat(uuid.contains(replaceTarget)).isFalse();
    }

    @Test
    void generate_length_target_replacement_case1() {
        int length = 10;
        String replaceTarget = "-";
        String replacement = "!";
        String uuid = uuidGenerator.generate(length, replaceTarget, replacement);

        assertThat(uuid).isNotBlank();
        assertThat(uuid.contains(replaceTarget)).isFalse();
        assertThat(uuid.contains(replacement)).isTrue();
    }

    @Test
    void generate_length_target_replacement_case2() {
        int length = 25;
        String replaceTarget = "-";
        String replacement = "))";
        String uuid = uuidGenerator.generate(length, replaceTarget, replacement);

        assertThat(uuid).isNotBlank();
        assertThat(uuid.contains(replaceTarget)).isFalse();
        assertThat(uuid.contains(replacement)).isTrue();
    }
}