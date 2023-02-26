package ru.akvine.prorise.exceptions;

import lombok.Data;
import ru.akvine.prorise.service.dto.BaseBean;

@Data
public class BaseEntityAlreadyFoundException extends RuntimeException {
    private BaseBean beanParams;

    public BaseEntityAlreadyFoundException(BaseBean beanParams) {
        this.beanParams = beanParams;
    }
}
