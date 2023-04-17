package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.KPIControllerMeta;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.kpi.GetKPIResponse;
import ru.akvine.prorise.rest.validator.KPIValidator;
import ru.akvine.prorise.service.KPIService;
import ru.akvine.prorise.service.dto.kpi.KPI;
import ru.akvine.prorise.service.dto.kpi.KPIResult;

@RestController
@RequiredArgsConstructor
public class KPIController implements KPIControllerMeta {
    private final KPIValidator kpiValidator;
    private final KPIService kpiService;

    @Override
    public Response getKPI() {
//        kpiValidator.verifyGetKPIRequest();
        KPIResult kpiResult = kpiService.getKPI(new KPI());
        return new GetKPIResponse()
                .setCompletedTasks(kpiResult.getCompletedTasks());
    }
}
