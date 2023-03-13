package ru.akvine.prorise.exceptions.goal;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.service.dto.BaseBean;

public class GoalEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public GoalEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
