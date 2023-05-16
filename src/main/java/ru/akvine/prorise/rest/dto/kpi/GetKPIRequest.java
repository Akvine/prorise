package ru.akvine.prorise.rest.dto.kpi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.service.constants.DateConstants;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class GetKPIRequest {
    @NotBlank
    private String filterType;

    @NotBlank
    private KPIFilter kpiFilter;

    @Nullable
    @JsonFormat(pattern = DateConstants.LOCAL_DATE_TIME_FORMAT)
    private LocalDateTime startDate;

    @Nullable
    @JsonFormat(pattern = DateConstants.LOCAL_DATE_TIME_FORMAT)
    private LocalDateTime endDate;
}
