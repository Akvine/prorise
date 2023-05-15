package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.employer.EmployerType;
import ru.akvine.prorise.rest.dto.employer.EmployerCreateRequest;
import ru.akvine.prorise.rest.dto.employer.EmployerListResponse;
import ru.akvine.prorise.rest.dto.employer.EmployerResponse;
import ru.akvine.prorise.rest.dto.employer.EmployerUpdateRequest;
import ru.akvine.prorise.service.dto.employer.EmployerBean;
import ru.akvine.prorise.service.DateService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployerConverter {
    private final DateService dateService;

    public EmployerBean convertToEmployerBean(EmployerCreateRequest request) {
        Preconditions.checkNotNull(request, "employerCreateRequest is null");
        return new EmployerBean()
                .setFirstName(request.getFirstName())
                .setSecondName(request.getSecondName())
                .setThirdName(request.getThirdName())
                .setEmployerType(EmployerType.safeValueOf(request.getEmployerType()))
                .setEmploymentDate(dateService.toLocalDate(request.getEmploymentDate()))
                .setDismissalDate(dateService.toLocalDate(request.getDismissalDate()))
                .setTeamUuid(request.getTeamUuid());
    }

    public EmployerBean convertToEmployerBean(EmployerUpdateRequest request) {
        Preconditions.checkNotNull(request, "employerUpdateRequest is null");

        EmployerBean employerBean = new EmployerBean()
                .setUuid(request.getUuid())
                .setFirstName(request.getFirstName())
                .setSecondName(request.getSecondName())
                .setThirdName(request.getThirdName())
                .setEmploymentDate(request.getEmploymentDate())
                .setDismissalDate(request.getEmploymentDate())
                .setTeamUuid(request.getTeamUuid());

        if (request.getEmployerType() != null) {
            employerBean.setEmployerType(EmployerType.safeValueOf(request.getEmployerType()));
        }

        return employerBean;
    }

    public EmployerResponse convertToEmployerResponse(EmployerBean employerBean) {
        Preconditions.checkNotNull(employerBean, "employerBean is null");
        return new EmployerResponse()
                .setUuid(employerBean.getUuid())
                .setFirstName(employerBean.getFirstName())
                .setSecondName(employerBean.getSecondName())
                .setThirdName(employerBean.getThirdName())
                .setDismissalDate(employerBean.getDismissalDate())
                .setEmploymentDate(employerBean.getEmploymentDate())
                .setEmploymentType(employerBean.getEmployerType().name())
                .setTeamUuid(employerBean.getTeam().getUuid());
    }

    public EmployerListResponse convertToEmployerListResponse(List<EmployerBean> list) {
        Preconditions.checkNotNull(list, "employerList is null");
        List<EmployerResponse> employers = list
                .stream()
                .map(this::convertToEmployerResponse)
                .collect(Collectors.toList());
        return new EmployerListResponse()
                .setEmployers(employers);
    }
}
