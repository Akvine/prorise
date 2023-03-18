package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.entities.project.ProjectType;
import ru.akvine.prorise.rest.dto.project.ProjectCreateRequest;
import ru.akvine.prorise.rest.dto.project.ProjectUpdateRequest;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.akvine.prorise.TestConstants.Entities;
import static ru.akvine.prorise.TestConstants.PROJECT_ENDPOINT;

@Transactional
class ProjectControllerTest extends ApiBaseTest {
    @Test
    @DisplayName("Get projects - SUCCESS")
    void getProjects_success() throws Exception {
        doGet(PROJECT_ENDPOINT, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.projects").isNotEmpty());
    }

    @Test
    @DisplayName("Get project by uuid - SUCCESS")
    void getProjectByUuid_success() throws Exception {
        String departmentUuid = Entities.PROJECT_UUID_1;
        doGet(PROJECT_ENDPOINT + "/" + departmentUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("project_title_1"))
                .andExpect(jsonPath("$.description").value("project_description_1"))
                .andExpect(jsonPath("$.startDate").value("2023-03-19"))
                .andExpect(jsonPath("$.endDate").isEmpty())
                .andExpect(jsonPath("$.teamUuid").value(Entities.TEAM_UUID_1));
    }

    @Test
    @DisplayName("Get project by uuid - FAIL - not found")
    void getProjectUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doGet(PROJECT_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }

    @Test
    @DisplayName("Create project - SUCCESS")
    void createProject_success() throws Exception {
        ProjectCreateRequest request = new ProjectCreateRequest()
                .setTitle("Some new title")
                .setDescription("Some new description")
                .setStartDate(LocalDate.now().toString())
                .setType(ProjectType.TECHNICAL.name())
                .setTeamUuid(Entities.TEAM_UUID_1);

        doPost(PROJECT_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("Some new description"))
                .andExpect(jsonPath("$.teamUuid").value(Entities.TEAM_UUID_1))
                .andExpect(jsonPath("$.type").value(ProjectType.TECHNICAL.name()));
    }

    @Test
    @DisplayName("Update project - SUCCESS")
    void updateProject_success() throws Exception {
        String projectUuid = Entities.PROJECT_UUID_1;
        ProjectUpdateRequest request = new ProjectUpdateRequest()
                .setUuid(projectUuid)
                .setTitle("Some new title")
                .setType(ProjectType.STRATEGY.name());
        doPut(PROJECT_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("project_description_1"))
                .andExpect(jsonPath("$.teamUuid").value(Entities.TEAM_UUID_1))
                .andExpect(jsonPath("$.type").value(ProjectType.STRATEGY.name()))
                .andExpect(jsonPath("$.endDate").isEmpty());
    }

    @Test
    @DisplayName("Delete project - SUCCESS")
    void deleteProject_success() throws Exception {
        String projectUuid1 = Entities.PROJECT_UUID_1;
        doDelete(PROJECT_ENDPOINT + "/" + projectUuid1, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"));
    }

    @Test
    @DisplayName("Delete project by uuid - FAIL - not found")
    void deleteProjectByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doDelete(PROJECT_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }
}