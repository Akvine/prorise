package ru.akvine.prorise.rest.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.entities.task.PriorityType;
import ru.akvine.prorise.entities.task.StatusType;
import ru.akvine.prorise.rest.dto.task.TaskCreateRequest;
import ru.akvine.prorise.rest.dto.task.TaskUpdateRequest;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.akvine.prorise.TestConstants.*;

@Transactional
class TaskControllerTest extends ApiBaseTest {
    @Test
    @DisplayName("Get tasks - SUCCESS")
    void getTasks_success() throws Exception {
        doGet(Endpoints.TASK_ENDPOINT, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.tasks").isNotEmpty());
    }

    @Test
    @DisplayName("Get task by uuid - SUCCESS")
    void getTaskByUuid_success() throws Exception {
        String taskUuid = Entities.TASK_UUID_1;
        doGet(Endpoints.TASK_ENDPOINT + "/" + taskUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("task_title_1"))
                .andExpect(jsonPath("$.description").value("task_description_1"))
                .andExpect(jsonPath("$.startDate").value("2023-03-19"))
                .andExpect(jsonPath("$.endDate").isEmpty())
                .andExpect(jsonPath("$.priority").value("MEDIUM"))
                .andExpect(jsonPath("$.status").value("IN_PROGRESS"))
                .andExpect(jsonPath("$.employerUuid").value(Entities.EMPLOYER_UUID_1))
                .andExpect(jsonPath("$.goalUuid").value(Entities.GOAL_UUID_1));
    }

    @Test
    @DisplayName("Get task by uuid - FAIL - not found")
    void getTaskUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doGet(Endpoints.TASK_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }

    @Test
    @DisplayName("Create task - SUCCESS")
    void createTask_success() throws Exception {
        TaskCreateRequest request = new TaskCreateRequest()
                .setTitle("Some new title")
                .setDescription("Some new description")
                .setStartDate(LocalDate.now().toString())
                .setEmployerUuid(Entities.EMPLOYER_UUID_1)
                .setGoalUuid(Entities.GOAL_UUID_1)
                .setPriority(PriorityType.MEDIUM.name())
                .setStatus(StatusType.IN_REVIEW.name());

        doPost(Endpoints.TASK_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("Some new description"))
                .andExpect(jsonPath("$.employerUuid").value(Entities.EMPLOYER_UUID_1))
                .andExpect(jsonPath("$.goalUuid").value(Entities.GOAL_UUID_1))
                .andExpect(jsonPath("$.status").value(StatusType.IN_REVIEW.name()))
                .andExpect(jsonPath("$.priority").value(PriorityType.MEDIUM.name()));
    }

    @Test
    @DisplayName("Update task - SUCCESS")
    void updateTask_success() throws Exception {
        String taskUuid = Entities.TASK_UUID_1;
        TaskUpdateRequest request = new TaskUpdateRequest()
                .setUuid(taskUuid)
                .setTitle("Some new title")
                .setDescription("Some new description")
                .setStartDate(LocalDate.now().toString());

        doPut(Endpoints.TASK_ENDPOINT, request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"))
                .andExpect(jsonPath("$.title").value("Some new title"))
                .andExpect(jsonPath("$.description").value("Some new description"))
                .andExpect(jsonPath("$.startDate").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.endDate").isEmpty());
    }

    @Test
    @DisplayName("Delete task - SUCCESS")
    void deleteTask_success() throws Exception {
        String taskUuid = Entities.TASK_UUID_1;
        doDelete(Endpoints.TASK_ENDPOINT + "/" + taskUuid, null)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.responseStatus").value("SUCCESS"));
    }

    @Test
    @DisplayName("Delete task by uuid - FAIL - not found")
    void deleteTaskByUuid_fail_notFound() throws Exception {
        String notExistsUuid = Entities.ENTITY_NOT_FOUND;
        doDelete(Endpoints.TASK_ENDPOINT + "/" + notExistsUuid, null)
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.responseStatus").value("FAIL"));
    }
}