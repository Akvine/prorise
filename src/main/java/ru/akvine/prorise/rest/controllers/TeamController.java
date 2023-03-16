package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.TeamControllerMeta;
import ru.akvine.prorise.rest.converter.TeamConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.dto.team.TeamCreateRequest;
import ru.akvine.prorise.rest.dto.team.TeamUpdateRequest;
import ru.akvine.prorise.rest.validator.TeamValidator;
import ru.akvine.prorise.service.TeamService;
import ru.akvine.prorise.service.dto.team.TeamBean;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/teams")
public class TeamController implements TeamControllerMeta {
    private final TeamService teamService;
    private final TeamValidator teamValidator;
    private final TeamConverter teamConverter;

    @Override
    public Response get() {
        List<TeamBean> teams = teamService.get();
        return teamConverter.convertToTeamListResponse(teams);
    }

    @Override
    public Response getByUuid(String uuid) {
        TeamBean team = teamService.getByUuid(uuid);
        return teamConverter.convertToTeamResponse(team);
    }

    @Override
    public Response create(TeamCreateRequest request) {
        TeamBean teamBean = teamConverter.convertToTeamBean(request);
        TeamBean createdBean = teamService.create(teamBean);
        return teamConverter.convertToTeamResponse(createdBean);
    }

    @Override
    public Response update(TeamUpdateRequest request) {
        TeamBean teamBean = teamConverter.convertToTeamBean(request);
        TeamBean updatedBean = teamService.update(teamBean);
        return teamConverter.convertToTeamResponse(updatedBean);
    }

    @Override
    public Response deleteByUuid(String uuid) {
        teamService.deleteByUuid(uuid);
        return new SuccessfulResponse();
    }
}
