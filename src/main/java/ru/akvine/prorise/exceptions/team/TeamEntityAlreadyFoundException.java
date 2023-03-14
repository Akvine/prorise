package ru.akvine.prorise.exceptions.team;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;

public class TeamEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public TeamEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
