package ru.akvine.prorise.exceptions.goal;

import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;

public class GoalEntityNotFoundException extends BaseEntityNotFoundException {
    public GoalEntityNotFoundException(String uuid) {
        super(uuid);
    }
}
