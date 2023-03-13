package ru.akvine.prorise.exceptions.task;

import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;

public class TaskEntityNotFoundException extends BaseEntityNotFoundException {
    public TaskEntityNotFoundException(String uuid) {
        super(uuid);
    }
}
