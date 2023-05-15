package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class KPIControllerTest extends ApiBaseTest {
    @Test
    @DisplayName("Get KPI - FAIL")
    void getKPI_fail_kpiNotExists() throws Exception {

    }
}