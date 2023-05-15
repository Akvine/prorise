package ru.akvine.prorise.rest.dto.kpi;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.service.dto.kpi.KPIStatistics;

@Data
@Accessors(chain = true)
public class GetKPIResponse extends SuccessfulResponse {
    private KPIStatistics kpiStatistics;
}
