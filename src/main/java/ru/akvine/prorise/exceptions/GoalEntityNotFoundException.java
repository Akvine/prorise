package ru.akvine.prorise.exceptions;

public class GoalEntityNotFoundException extends RuntimeException {
    public GoalEntityNotFoundException(String message) {
        super(message);
    }
}
