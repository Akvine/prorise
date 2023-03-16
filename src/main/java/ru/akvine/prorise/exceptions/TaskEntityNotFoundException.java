package ru.akvine.prorise.exceptions;

public class TaskEntityNotFoundException extends RuntimeException {
    public TaskEntityNotFoundException(String message) {
        super(message);
    }
}
