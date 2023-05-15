package ru.akvine.prorise.rest.dto.kpi;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class GetKPIRequest {
    @NotBlank
    private String filterType;

    @NotBlank
    private KPIFilter kpiFilter;

    @Nullable
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate startDate;

    @Nullable
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate endDate;
}
