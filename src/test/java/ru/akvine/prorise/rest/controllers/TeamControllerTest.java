package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.rest.dto.team.TeamCreateRequest;
import ru.akvine.prorise.rest.dto.team.TeamUpdateRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.akvine.prorise.TestConstants.Entities;
import static ru.akvine.prorise.TestConstants.TEAM_ENDPOINT;

@Transactional
class TeamControllerTest extends ApiBaseTest {
    @Test
    @DisplayName("Get teams - SUCCESS")
    void getTeams_success() throws Exception {
        doGet(TEAM_ENDPOINT, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.teams").isNotEmpty());
    }

    @Test
    @DisplayName("Get team by uuid - SUCCESS")
    void getTeamByUuid_success() throws Exception {
        String departmentUuid = Entities.TEAM_UUID_1;
        doGet(TEAM_ENDPOINT + "/" + departmentUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("team_title_1"))
                .andExpect(jsonPath("$.description").value("team_description_1"))
                .andExpect(jsonPath("$.departmentUuid").value("department_uuid_1"));
    }

    @Test
    @DisplayName("Get team by uuid - FAIL - not found")
    void getTeamByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doGet(TEAM_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }

    @Test
    @DisplayName("Create team - SUCCESS")
    void createTeam_success() throws Exception {
        TeamCreateRequest request = new TeamCreateRequest()
                .setTitle("Some new title")
                .setDescription("Some new description")
                .setDepartmentUuid(Entities.DEPARTMENT_UUID_1);

        doPost(TEAM_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("Some new description"))
                .andExpect(jsonPath("$.departmentUuid").value(Entities.DEPARTMENT_UUID_1));
    }

    @Test
    @DisplayName("Update team - SUCCESS")
    void updateTeam_success() throws Exception {
        String teamUuid = Entities.TEAM_UUID_1;
        TeamUpdateRequest request = new TeamUpdateRequest()
                .setUuid(teamUuid)
                .setTitle("Some new title");
        doPut(TEAM_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("team_description_1"))
                .andExpect(jsonPath("$.departmentUuid").value(Entities.DEPARTMENT_UUID_1));
    }

    @Test
    @DisplayName("Delete team - SUCCESS")
    void deleteTeam_success() throws Exception {
        String teamUuid1 = Entities.TEAM_UUID_1;
        doDelete(TEAM_ENDPOINT + "/" + teamUuid1, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"));
    }

    @Test
    @DisplayName("Delete team by uuid - FAIL - not found")
    void deleteTeamByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doDelete(TEAM_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }
}