package ru.akvine.prorise.exceptions.project;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.service.dto.BaseBean;

public class ProjectEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public ProjectEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
