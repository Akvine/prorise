package ru.akvine.prorise.exceptions.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.akvine.prorise.exceptions.DepartmentNotFoundException;
import ru.akvine.prorise.rest.dto.common.CommonErrorCodes;
import ru.akvine.prorise.rest.dto.common.ErrorResponse;

import java.time.LocalDate;

@RestControllerAdvice
public class CrudExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({DepartmentNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleDepartmentNotFoundException(DepartmentNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(
                CommonErrorCodes.DEPARTMENT_NOT_FOUND,
                exception.getMessage(),
                LocalDate.now()
        );
        return new ResponseEntity<>(errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
