package ru.akvine.prorise.rest.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;

import java.util.List;

@Data
@Accessors(chain = true)
public class ListResponse<D extends BaseDto> extends SuccessfulResponse {
    private List<D> list;
}
