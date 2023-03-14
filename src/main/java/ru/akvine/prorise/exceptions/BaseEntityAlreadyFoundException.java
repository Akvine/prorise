package ru.akvine.prorise.exceptions;

import lombok.Data;

@Data
public class BaseEntityAlreadyFoundException extends RuntimeException {
    private BaseBean beanParams;

    public BaseEntityAlreadyFoundException(BaseBean beanParams) {
        this.beanParams = beanParams;
    }
}
