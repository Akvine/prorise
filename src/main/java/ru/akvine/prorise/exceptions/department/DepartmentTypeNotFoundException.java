package ru.akvine.prorise.exceptions.department;

import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;

public class DepartmentTypeNotFoundException extends BaseEntityNotFoundException {
    public DepartmentTypeNotFoundException(String uuid) {
        super(uuid);
    }
}
