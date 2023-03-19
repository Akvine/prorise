package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.TestConstants;
import ru.akvine.prorise.entities.employer.EmployerType;
import ru.akvine.prorise.rest.dto.employer.EmployerCreateRequest;
import ru.akvine.prorise.rest.dto.employer.EmployerUpdateRequest;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.akvine.prorise.TestConstants.EMPLOYER_ENDPOINT;
import static ru.akvine.prorise.TestConstants.Entities;

@Transactional
class EmployerControllerTest extends ApiBaseTest {
    @Test
    @DisplayName("Get employers - SUCCESS")
    void getEmployers_success() throws Exception {
        doGet(EMPLOYER_ENDPOINT, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.employers").isNotEmpty());
    }

    @Test
    @DisplayName("Get employer by uuid - SUCCESS")
    void getEmployerByUuid_success() throws Exception {
        String employerUuid = Entities.EMPLOYER_UUID_1;
        doGet(EMPLOYER_ENDPOINT + "/" + employerUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.firstName").value("employer_first_name_1"))
                .andExpect(jsonPath("$.secondName").value("employer_second_name_1"))
                .andExpect(jsonPath("$.thirdName").isEmpty())
                .andExpect(jsonPath("$.employmentDate").value("2023-03-19"))
                .andExpect(jsonPath("$.dismissalDate").isEmpty())
                .andExpect(jsonPath("$.employmentType").value("WORKER"))
                .andExpect(jsonPath("$.teamUuid").value(Entities.TEAM_UUID_1));
    }

    @Test
    @DisplayName("Get employer by uuid - FAIL - not found")
    void getEmployerUuid_fail_notFound() throws Exception {
        String notExistsUuid = TestConstants.Entities.ENTITY_NOT_FOUND;
        doGet(EMPLOYER_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }

    @Test
    @DisplayName("Create employer - SUCCESS")
    void createEmployer_success() throws Exception {
        EmployerCreateRequest request = new EmployerCreateRequest()
                .setFirstName("Some new first name")
                .setSecondName("Some new second name")
                .setThirdName("Some new third name")
                .setEmployerType(EmployerType.ANALYST.name())
                .setEmploymentDate(LocalDate.now().toString())
                .setTeamUuid(Entities.TEAM_UUID_1);

        doPost(EMPLOYER_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.firstName").value("Some new first name"))
                .andExpect(jsonPath("$.secondName").value("Some new second name"))
                .andExpect(jsonPath("$.thirdName").value("Some new third name"))
                .andExpect(jsonPath("$.employmentDate").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.dismissalDate").isEmpty())
                .andExpect(jsonPath("$.teamUuid").value(Entities.TEAM_UUID_1))
                .andExpect(jsonPath("$.employmentType").value(EmployerType.ANALYST.name()));
    }

    @Test
    @DisplayName("Update employer - SUCCESS")
    void updateEmployer_success() throws Exception {
        String employerUuid = Entities.EMPLOYER_UUID_1;
        EmployerUpdateRequest request = new EmployerUpdateRequest()
                .setUuid(employerUuid)
                .setFirstName("Some new first name")
                .setEmployerType(EmployerType.LEAD.name());

        doPut(EMPLOYER_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.firstName").value("Some new first name"))
                .andExpect(jsonPath("$.secondName").value("employer_second_name_1"))
                .andExpect(jsonPath("$.teamUuid").value(Entities.TEAM_UUID_1))
                .andExpect(jsonPath("$.employmentType").value(EmployerType.LEAD.name()))
                .andExpect(jsonPath("$.employmentDate").value("2023-03-19"));
    }

    @Test
    @DisplayName("Delete employer - SUCCESS")
    void deleteEmployer_success() throws Exception {
        String employerUuid = Entities.EMPLOYER_UUID_1;
        doDelete(EMPLOYER_ENDPOINT + "/" + employerUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"));
    }

    @Test
    @DisplayName("Delete employer by uuid - FAIL - not found")
    void deleteEmployerByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doDelete(EMPLOYER_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }
}