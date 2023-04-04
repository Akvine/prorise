package ru.akvine.prorise.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.akvine.prorise.exceptions.KPIFilterNotFoundException;
import ru.akvine.prorise.rest.dto.common.CommonErrorCodes;
import ru.akvine.prorise.rest.dto.common.ErrorResponse;

import java.time.LocalDate;

@RestControllerAdvice
public class ValidationExceptionHandler {
    @ExceptionHandler({KPIFilterNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleKPIFilterNotFoundException(KPIFilterNotFoundException kpiFilterNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(
                CommonErrorCodes.Validation.KPI_NOT_FOUND,
                kpiFilterNotFoundException.getMessage(),
                LocalDate.now()
        );
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
