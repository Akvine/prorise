package ru.akvine.prorise.rest.converter;

import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.team.TeamDto;
import ru.akvine.prorise.service.dto.team.TeamBean;

@Component
public class TeamConverter extends BaseConverter<TeamDto, TeamBean> {
    @Override
    protected TeamDto convertBeanToDto(TeamBean bean) {
        return new TeamDto()
                .setDescription(bean.getDescription())
                .setDepartmentUuid(bean.getDepartmentUuid());
    }

    @Override
    protected TeamBean convertDtoToBean(TeamDto dto) {
        return new TeamBean()
                .setDescription(dto.getDescription())
                .setDepartmentUuid(dto.getDepartmentUuid());
    }

    @Override
    protected TeamBean createEmptyBean() {
        return new TeamBean();
    }
}
