package ru.akvine.prorise.exceptions.employer;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;

public class EmployerEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public EmployerEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
