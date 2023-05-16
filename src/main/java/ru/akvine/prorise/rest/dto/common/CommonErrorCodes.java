package ru.akvine.prorise.rest.dto.common;

public class CommonErrorCodes {
    private CommonErrorCodes() {}

    public static final String DEPARTMENT_NOT_FOUND = "department.notFound.error";
    public static final String TEAM_NOT_FOUND = "team.notFound.error";
    public static final String PROJECT_NOT_FOUND = "project.notFound.error";
    public static final String GOAL_NOT_FOUND = "goal.notFound.error";
    public static final String TASK_NOT_FOUND = "task.notFound.error";
    public static final String EMPLOYER_NOT_FOUND = "employer.notFound.error";

    public interface Validation {
        String UUID_PRESENT = "uuid.present.error";
        String UUID_NOT_PRESENT = "uuid.not.present.error";
        String INCORRECT_DATE_RANGE = "incorrect.dateRange.error";
    }
}
