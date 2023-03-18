package ru.akvine.prorise.rest.dto.common;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ErrorResponse implements Response {
    private final String code;
    private final String message;
    private final LocalDate time;

    public ErrorResponse(String code, String message, LocalDate time) {
        this.code = code;
        this.message = message;
        this.time = time;
    }

    @Override
    public ResponseStatus getResponseStatus() {
        return ResponseStatus.FAIL;
    }
}


