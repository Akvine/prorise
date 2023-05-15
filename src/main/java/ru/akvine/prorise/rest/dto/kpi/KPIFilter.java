package ru.akvine.prorise.rest.dto.kpi;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.kpi.beans.Department;
import ru.akvine.prorise.rest.dto.kpi.beans.Employer;
import ru.akvine.prorise.rest.dto.kpi.beans.Team;

import javax.validation.Valid;

@Getter
@Setter
@Accessors(chain = true)
public class KPIFilter {
    @Valid
    private Department department;

    @Valid
    private Team team;

    @Valid
    private Employer employer;
}
