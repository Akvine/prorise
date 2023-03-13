package ru.akvine.prorise.exceptions.project;

import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;

public class ProjectEntityNotFoundException extends BaseEntityNotFoundException {
    public ProjectEntityNotFoundException(String uuid) {
        super(uuid);
    }
}
