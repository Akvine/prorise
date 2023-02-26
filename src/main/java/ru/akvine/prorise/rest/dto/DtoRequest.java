package ru.akvine.prorise.rest.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class DtoRequest<D extends BaseDto> {
    @NotNull
    @Valid
    private D dto;
}
