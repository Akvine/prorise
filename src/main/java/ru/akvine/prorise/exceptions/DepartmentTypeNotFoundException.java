package ru.akvine.prorise.exceptions;

public class DepartmentTypeNotFoundException extends RuntimeException {
    public DepartmentTypeNotFoundException(String message) {
        super(message);
    }
}
