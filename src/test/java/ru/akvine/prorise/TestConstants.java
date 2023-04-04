package ru.akvine.prorise;

public class TestConstants {
    private TestConstants() {}

    public interface Entities {
        String ENTITY_NOT_FOUND = "entity not found";
        String DEPARTMENT_UUID_1 = "department_uuid_1";
        String TEAM_UUID_1 = "team_uuid_1";
        String PROJECT_UUID_1 = "project_uuid_1";
        String GOAL_UUID_1 = "goal_uuid_1";
        String TASK_UUID_1 = "task_uuid_1";
        String EMPLOYER_UUID_1 = "employer_uuid_1";
    }

    public interface Endpoints {
        // Entities
        String DEPARTMENT_ENDPOINT = "/departments";
        String TEAM_ENDPOINT = "/teams";
        String PROJECT_ENDPOINT = "/projects";
        String GOAL_ENDPOINT = "/goals";
        String TASK_ENDPOINT = "/tasks";
        String EMPLOYER_ENDPOINT = "/employers";

        // Business
        String KPI_ENDPOINT = "/kpi";
    }
}
