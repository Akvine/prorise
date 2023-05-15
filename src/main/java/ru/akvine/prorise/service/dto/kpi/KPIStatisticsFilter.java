package ru.akvine.prorise.service.dto.kpi;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.service.dto.kpi.filter.DepartmentFilter;
import ru.akvine.prorise.service.dto.kpi.filter.EmployerFilter;
import ru.akvine.prorise.service.dto.kpi.filter.FilterType;
import ru.akvine.prorise.service.dto.kpi.filter.TeamFilter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@Accessors(chain = true)
public class KPIStatisticsFilter {
    @NotBlank
    private FilterType filterType;

    @Nullable
    private EmployerFilter employerFilter;

    @Nullable
    private TeamFilter teamFilter;

    @Nullable
    private DepartmentFilter departmentFilter;
}
