package ru.akvine.prorise.exceptions.team;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.service.dto.BaseBean;

public class TeamEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public TeamEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
