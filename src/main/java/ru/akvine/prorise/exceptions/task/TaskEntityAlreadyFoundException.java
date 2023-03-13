package ru.akvine.prorise.exceptions.task;

import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.service.dto.BaseBean;

public class TaskEntityAlreadyFoundException extends BaseEntityAlreadyFoundException {
    public TaskEntityAlreadyFoundException(BaseBean beanParams) {
        super(beanParams);
    }
}
