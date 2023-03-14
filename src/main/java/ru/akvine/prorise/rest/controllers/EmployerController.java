package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.EmployerConverter;
import ru.akvine.prorise.rest.dto.employer.EmployerDto;
import ru.akvine.prorise.rest.validator.EmployerValidator;
import ru.akvine.prorise.service.EmployerService;
import ru.akvine.prorise.service.dto.employer.EmployerBean;

@RestController
@RequestMapping(value = "/employers")
@RequiredArgsConstructor
public class EmployerController extends BaseController<EmployerDto, EmployerBean> {

    private final EmployerConverter employerConverter;
    private final EmployerValidator employerValidator;
    private final EmployerService employerService;

    @Override
    protected BaseValidator getValidator() {
        return employerValidator;
    }

    @Override
    protected BaseConverter getConverter() {
        return employerConverter;
    }

    @Override
    protected BaseService getService() {
        return employerService;
    }
}
