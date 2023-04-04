package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.rest.dto.kpi.GetKPIRequest;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.akvine.prorise.TestConstants.*;

@Transactional
class KPIControllerTest extends ApiBaseTest {
    @Test
    @DisplayName("Get KPI - FAIL")
    void getKPI_fail_kpiNotExists() throws Exception {
        GetKPIRequest request = new GetKPIRequest()
                .setEmployerUuid(Entities.EMPLOYER_UUID_1)
                .setFilters(List.of("NOT_EXISTS_FILTER"));
        doGet(Endpoints.KPI_ENDPOINT, request)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"))
                .andExpect(jsonPath("$.code").value("kpi.notFound.error"));
    }
}