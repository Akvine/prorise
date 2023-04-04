package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.KPIControllerMeta;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.kpi.GetKPIRequest;
import ru.akvine.prorise.rest.validator.KPIValidator;

@RestController
@RequiredArgsConstructor
public class KPIController implements KPIControllerMeta {
    private final KPIValidator kpiValidator;

    @Override
    public Response getKPI(GetKPIRequest getKPIRequest) {
        kpiValidator.verifyGetKPIRequest(getKPIRequest);
        return null;
    }
}
