package ru.akvine.prorise.exceptions.department;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;

public class DepartmentAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public DepartmentAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
