package ru.akvine.prorise.service.dto.kpi;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class KPI {
    private String employerUuid;
    private List<String> filters;
}
