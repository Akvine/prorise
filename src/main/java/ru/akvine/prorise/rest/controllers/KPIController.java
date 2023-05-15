package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.KPIControllerMeta;
import ru.akvine.prorise.rest.converter.KPIConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.kpi.GetKPIRequest;
import ru.akvine.prorise.service.KPIService;
import ru.akvine.prorise.service.dto.kpi.KPIStatistics;
import ru.akvine.prorise.service.dto.kpi.KPIStatisticsFilter;

@RestController
@RequiredArgsConstructor
public class KPIController implements KPIControllerMeta {
    private final KPIService kpiService;
    private final KPIConverter kpiConverter;

    @Override
    public Response getKPI(GetKPIRequest getKPIRequest) {
        KPIStatisticsFilter kpiStatisticsFilter = kpiConverter.convertToKPIStatisticsStart(getKPIRequest);
        KPIStatistics kpiStatistics = kpiService.getKPI(kpiStatisticsFilter);
        return kpiConverter.convertToGetKPIResponse(kpiStatistics);
    }
}
