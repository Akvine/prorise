package ru.akvine.prorise.rest.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

@Data
@Accessors(chain = true)
public class DtoResponse<D extends BaseDto> extends SuccessfulResponse {
    private D dto;
}
