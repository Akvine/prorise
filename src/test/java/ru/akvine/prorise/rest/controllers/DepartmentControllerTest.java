package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.rest.dto.department.DepartmentCreateRequest;
import ru.akvine.prorise.rest.dto.department.DepartmentUpdateRequest;

import static ru.akvine.prorise.TestConstants.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
class DepartmentControllerTest extends ApiBaseTest {

    @Test
    @DisplayName("Get departments - SUCCESS")
    void getDepartments_success() throws Exception {
        doGet(Endpoints.DEPARTMENT_ENDPOINT, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.departments").isNotEmpty());
    }

    @Test
    @DisplayName("Get department by uuid - SUCCESS")
    void getDepartmentByUuid_success() throws Exception {
        String departmentUuid = Entities.DEPARTMENT_UUID_1;
        doGet(Endpoints.DEPARTMENT_ENDPOINT + "/" + departmentUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("department_title_1"))
                .andExpect(jsonPath("$.description").value("department_description_1"))
                .andExpect(jsonPath("$.type").value("IT"));
    }

    @Test
    @DisplayName("Get department by uuid - FAIL - not found")
    void getDepartmentByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doGet(Endpoints.DEPARTMENT_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }

    @Test
    @DisplayName("Create department - SUCCESS")
    void createDepartment_success() throws Exception {
        DepartmentCreateRequest request = new DepartmentCreateRequest()
                .setTitle("Some new department")
                .setDescription("Some new description")
                .setType(DepartmentType.HR.name());

        doPost(Endpoints.DEPARTMENT_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new department"))
                .andExpect(jsonPath("$.description").value("Some new description"))
                .andExpect(jsonPath("$.type").value("HR"));
    }

    @Test
    @DisplayName("Update department - SUCCESS")
    void updateDepartment_success() throws Exception {
        String departmentUuid = Entities.DEPARTMENT_UUID_1;
        DepartmentUpdateRequest request = new DepartmentUpdateRequest()
                .setUuid(departmentUuid)
                .setTitle("Some new title");
        doPut(Endpoints.DEPARTMENT_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("department_description_1"))
                .andExpect(jsonPath("$.type").value("IT"));
    }

    @Test
    @DisplayName("Delete department - SUCCESS")
    void deleteDepartment_success() throws Exception {
        String departmentUuid = Entities.DEPARTMENT_UUID_1;
        doDelete(Endpoints.DEPARTMENT_ENDPOINT + "/" + departmentUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"));
    }

    @Test
    @DisplayName("Delete department by uuid - FAIL - not found")
    void deleteDepartmentByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doDelete(Endpoints.DEPARTMENT_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }
}
