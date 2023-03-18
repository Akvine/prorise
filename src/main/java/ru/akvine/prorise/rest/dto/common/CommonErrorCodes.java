package ru.akvine.prorise.rest.dto.common;

public class CommonErrorCodes {
    private CommonErrorCodes() {}

    public static final String DEPARTMENT_NOT_FOUND = "department.notFound.error";

    public interface Validation {
        String UUID_PRESENT = "uuid.present.error";
        String UUID_NOT_PRESENT = "uuid.not.present.error";
    }
}
