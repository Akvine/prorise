package ru.akvine.prorise.exceptions.department;

import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;

public class DepartmentNotFoundException extends BaseEntityNotFoundException {
    public DepartmentNotFoundException(String uuid) {
        super(uuid);
    }
}
