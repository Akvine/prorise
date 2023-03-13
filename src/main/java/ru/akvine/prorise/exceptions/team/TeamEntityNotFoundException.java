package ru.akvine.prorise.exceptions.team;

import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;

public class TeamEntityNotFoundException extends BaseEntityNotFoundException {
    public TeamEntityNotFoundException(String uuid) {
        super(uuid);
    }
}
