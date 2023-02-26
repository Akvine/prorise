package ru.akvine.prorise.rest.dto.common;

import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorResponse implements Response {
    private final ResponseStatus status = ResponseStatus.FAIL;
    private final String code;
    private final String message;
    private final Date time;

    public ErrorResponse(String code, String message, Date time) {
        this.code = code;
        this.message = message;
        this.time = time;
    }
}


