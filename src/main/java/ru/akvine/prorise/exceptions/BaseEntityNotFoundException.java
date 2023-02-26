package ru.akvine.prorise.exceptions;

import lombok.Data;

@Data
public class BaseEntityNotFoundException extends RuntimeException {
    private String uuid;
    public BaseEntityNotFoundException(String uuid) {
        this.uuid = uuid;
    }
}
