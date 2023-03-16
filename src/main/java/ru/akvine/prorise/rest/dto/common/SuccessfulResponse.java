package ru.akvine.prorise.rest.dto.common;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class SuccessfulResponse implements Response {
    private final LocalDate time = LocalDate.now();
    @Override
    public ResponseStatus getResponseStatus() {
        return ResponseStatus.SUCCESS;
    }
}

