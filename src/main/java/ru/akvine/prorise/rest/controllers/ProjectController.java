package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.ProjectConverter;
import ru.akvine.prorise.rest.validator.ProjectValidator;
import ru.akvine.prorise.service.ProjectService;

@RestController
@RequestMapping(value = "/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectValidator projectValidator;
    private final ProjectService projectService;
    private final ProjectConverter projectConverter;

}
