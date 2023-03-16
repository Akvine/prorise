package ru.akvine.prorise.exceptions;

public class ProjectEntityNotFoundException extends RuntimeException {
    public ProjectEntityNotFoundException(String message) {
        super(message);
    }
}
