package ru.akvine.prorise.exceptions.task;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;

public class TaskEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public TaskEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
