package ru.akvine.prorise.exceptions;

public class TeamEntityNotFoundException extends RuntimeException {
    public TeamEntityNotFoundException(String message) {
        super(message);
    }
}
