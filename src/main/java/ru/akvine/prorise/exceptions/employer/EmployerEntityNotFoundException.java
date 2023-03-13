package ru.akvine.prorise.exceptions.employer;

import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;

public class EmployerEntityNotFoundException extends BaseEntityNotFoundException {
    public EmployerEntityNotFoundException(String uuid) {
        super(uuid);
    }
}
