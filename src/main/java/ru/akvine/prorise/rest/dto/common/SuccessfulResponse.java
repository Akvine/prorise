package ru.akvine.prorise.rest.dto.common;

import lombok.Getter;

import java.util.Date;

@Getter
public class SuccessfulResponse implements Response {
    private final Date time = new Date();
    @Override
    public ResponseStatus getStatus() {
        return ResponseStatus.SUCCESS;
    }
}

