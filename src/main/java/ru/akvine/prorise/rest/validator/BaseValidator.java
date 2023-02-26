package ru.akvine.prorise.rest.validator;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import ru.akvine.prorise.exceptions.ValidationException;
import ru.akvine.prorise.rest.dto.BaseDto;
import ru.akvine.prorise.rest.dto.DtoRequest;
import ru.akvine.prorise.rest.dto.common.CommonErrorCodes;

public class BaseValidator<D extends BaseDto> {
    public void validateCreateRequest(DtoRequest<D> request) {
        Preconditions.checkNotNull(request, "request is null");
        Preconditions.checkNotNull(request.getDto(), "request.dto is null");

        D dto = request.getDto();
        verifyUuidNotPresent(dto.getUuid());
    }

    public void validateUpdateRequest(DtoRequest<D> request) {
        Preconditions.checkNotNull(request, "request is null");
        Preconditions.checkNotNull(request.getDto(), "request.dto is null");

        D dto = request.getDto();
        verifyUuidPresent(dto.getUuid());
    }

    private void verifyUuidNotPresent(String uuid) {
        if (uuid != null) {
            throw new ValidationException(CommonErrorCodes.Validation.UUID_PRESENT);
        }
    }

    private void verifyUuidPresent(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new ValidationException(CommonErrorCodes.Validation.UUID_NOT_PRESENT);
        }
    }
}
