package ru.akvine.prorise.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.akvine.prorise.exceptions.ValidationException;
import ru.akvine.prorise.rest.dto.common.CommonErrorCodes;
import ru.akvine.prorise.rest.dto.common.ErrorResponse;

import java.time.LocalDate;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException validationException) {
        ErrorResponse errorResponse = new ErrorResponse(
                CommonErrorCodes.Validation.INCORRECT_DATE_RANGE,
                validationException.getMessage(),
                LocalDate.now()
        );
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
