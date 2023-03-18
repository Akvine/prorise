package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.team.TeamCreateRequest;
import ru.akvine.prorise.rest.dto.team.TeamListResponse;
import ru.akvine.prorise.rest.dto.team.TeamResponse;
import ru.akvine.prorise.rest.dto.team.TeamUpdateRequest;
import ru.akvine.prorise.service.dto.team.TeamBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TeamConverter {
    public TeamBean convertToTeamBean(TeamCreateRequest request) {
        Preconditions.checkNotNull(request, "teamCreateRequest is null");
        return new TeamBean()
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDepartmentUuid(request.getDepartmentUuid());
    }

    public TeamBean convertToTeamBean(TeamUpdateRequest request) {
        Preconditions.checkNotNull(request, "teamUpdateRequest is null");
        return new TeamBean()
                .setUuid(request.getUuid())
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDepartmentUuid(request.getDepartmentUuid());
    }

    public TeamResponse convertToTeamResponse(TeamBean team) {
        Preconditions.checkNotNull(team, "team is null");
        return new TeamResponse()
                .setDescription(team.getDescription())
                .setTitle(team.getTitle());
    }

    public TeamListResponse convertToTeamListResponse(List<TeamBean> teams) {
        Preconditions.checkNotNull(teams, "teams is null");
        List<TeamResponse> teamBeans = teams
                .stream()
                .map(this::convertToTeamResponse)
                .collect(Collectors.toList());
        return new TeamListResponse()
                .setTeams(teamBeans);
    }
}
