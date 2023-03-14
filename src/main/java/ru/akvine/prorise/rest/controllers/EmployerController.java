package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.EmployerConverter;
import ru.akvine.prorise.rest.validator.EmployerValidator;
import ru.akvine.prorise.service.EmployerService;

@RestController
@RequestMapping(value = "/employers")
@RequiredArgsConstructor
public class EmployerController {
    private final EmployerConverter employerConverter;
    private final EmployerValidator employerValidator;
    private final EmployerService employerService;

}
