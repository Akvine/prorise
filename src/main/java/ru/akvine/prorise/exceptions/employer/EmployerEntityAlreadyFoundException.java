package ru.akvine.prorise.exceptions.employer;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.service.dto.BaseBean;

public class EmployerEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public EmployerEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
