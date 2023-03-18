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

    // Endpoints
    public static final String DEPARTMENT_ENDPOINT = "/departments";
    public static final String TEAM_ENDPOINT = "/teams";
    public static final String PROJECT_ENDPOINT = "/projects";
    public static final String GOAL_ENDPOINT = "/goals";
    public static final String TASK_ENDPOINT = "/tasks";
    public static final String EMPLOYER_ENDPOINT = "/employers";
}
