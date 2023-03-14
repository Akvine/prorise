package ru.akvine.prorise.exceptions.goal;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;

public class GoalEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public GoalEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
