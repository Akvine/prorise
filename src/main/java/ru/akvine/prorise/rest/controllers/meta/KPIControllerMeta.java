package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.kpi.GetKPIRequest;

import javax.validation.Valid;

@RequestMapping(value = "/kpi")
public interface KPIControllerMeta {
    @GetMapping
    Response getKPI(@RequestBody @Valid GetKPIRequest getKPIRequest);
}
