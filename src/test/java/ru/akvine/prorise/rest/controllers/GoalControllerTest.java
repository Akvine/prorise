package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.TestConstants;
import ru.akvine.prorise.rest.dto.goal.GoalCreateRequest;
import ru.akvine.prorise.rest.dto.goal.GoalUpdateRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.akvine.prorise.TestConstants.Entities;
import static ru.akvine.prorise.TestConstants.GOAL_ENDPOINT;

@Transactional
class GoalControllerTest extends ApiBaseTest {
    @Test
    @DisplayName("Get goals - SUCCESS")
    void getGoals_success() throws Exception {
        doGet(GOAL_ENDPOINT, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.goals").isNotEmpty());
    }

    @Test
    @DisplayName("Get goal by uuid - SUCCESS")
    void getGoalByUuid_success() throws Exception {
        String goalUuid = Entities.GOAL_UUID_1;
        doGet(GOAL_ENDPOINT + "/" + goalUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("goal_title_1"))
                .andExpect(jsonPath("$.description").value("goal_description_1"))
                .andExpect(jsonPath("$.projectUuid").value(Entities.PROJECT_UUID_1));
    }

    @Test
    @DisplayName("Get goal by uuid - FAIL - not found")
    void getGoalUuid_fail_notFound() throws Exception {
        String notExistsUuid = TestConstants.Entities.ENTITY_NOT_FOUND;
        doGet(GOAL_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }

    @Test
    @DisplayName("Create goal - SUCCESS")
    void createGoal_success() throws Exception {
        GoalCreateRequest request = new GoalCreateRequest()
                .setTitle("Some new title")
                .setDescription("Some new description")
                .setProjectUuid(Entities.PROJECT_UUID_1);

        doPost(GOAL_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("Some new description"))
                .andExpect(jsonPath("$.projectUuid").value(Entities.PROJECT_UUID_1));
    }

    @Test
    @DisplayName("Update goal - SUCCESS")
    void updateGoal_success() throws Exception {
        String goalUuid = Entities.GOAL_UUID_1;
        GoalUpdateRequest request = new GoalUpdateRequest()
                .setUuid(goalUuid)
                .setDescription("Some new description");
        doPut(GOAL_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("goal_title_1"))
                .andExpect(jsonPath("$.description").value("Some new description"))
                .andExpect(jsonPath("$.projectUuid").value(Entities.PROJECT_UUID_1));
    }

    @Test
    @DisplayName("Delete goal - SUCCESS")
    void deleteGoal_success() throws Exception {
        String goalUuid = Entities.GOAL_UUID_1;
        doDelete(GOAL_ENDPOINT + "/" + goalUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"));
    }

    @Test
    @DisplayName("Delete goal by uuid - FAIL - not found")
    void deleteGoalByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doDelete(GOAL_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }
}