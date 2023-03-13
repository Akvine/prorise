package ru.akvine.prorise.exceptions.department;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.service.dto.BaseBean;

public class DepartmentAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public DepartmentAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
