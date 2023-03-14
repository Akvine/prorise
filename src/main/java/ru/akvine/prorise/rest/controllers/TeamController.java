package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.TeamConverter;
import ru.akvine.prorise.rest.validator.TeamValidator;
import ru.akvine.prorise.service.TeamService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teams")
public class TeamController {
    private final TeamService teamService;
    private final TeamValidator teamValidator;
    private final TeamConverter teamConverter;

}
