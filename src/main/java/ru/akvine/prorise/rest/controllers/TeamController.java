package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.BaseConverter;
import ru.akvine.prorise.rest.converter.TeamConverter;
import ru.akvine.prorise.rest.dto.team.TeamDto;
import ru.akvine.prorise.rest.validator.BaseValidator;
import ru.akvine.prorise.rest.validator.TeamValidator;
import ru.akvine.prorise.service.BaseService;
import ru.akvine.prorise.service.TeamService;
import ru.akvine.prorise.service.dto.team.TeamBean;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teams")
public class TeamController extends BaseController<TeamDto, TeamBean> {
    private final TeamService teamService;
    private final TeamValidator teamValidator;
    private final TeamConverter teamConverter;

    @Override
    protected BaseValidator getValidator() {
        return teamValidator;
    }

    @Override
    protected BaseConverter getConverter() {
        return teamConverter;
    }

    @Override
    protected BaseService getService() {
        return teamService;
    }
}
