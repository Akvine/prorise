package ru.akvine.prorise.exceptions;

public class EmployerEntityNotFoundException extends RuntimeException {
    public EmployerEntityNotFoundException(String message) {
        super(message);
    }
}
