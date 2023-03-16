package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.employer.EmployerType;
import ru.akvine.prorise.rest.dto.employer.EmployerCreateRequest;
import ru.akvine.prorise.rest.dto.employer.EmployerListResponse;
import ru.akvine.prorise.rest.dto.employer.EmployerResponse;
import ru.akvine.prorise.rest.dto.employer.EmployerUpdateRequest;
import ru.akvine.prorise.service.dto.employer.EmployerBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployerConverter {

    public EmployerBean convertToEmployerBean(EmployerCreateRequest request) {
        Preconditions.checkNotNull(request, "employerCreateRequest is null");
        return new EmployerBean()
                .setFirstName(request.getFirstName())
                .setSecondName(request.getSecondName())
                .setThirdName(request.getThirdName())
                .setEmployerType(EmployerType.safeValueOf(request.getEmployerType()))
                .setEmploymentDate(request.getEmploymentDate())
                .setDismissalDate(request.getEmploymentDate());
    }

    public EmployerBean convertToEmployerBean(EmployerUpdateRequest request) {
        Preconditions.checkNotNull(request, "employerUpdateRequest is null");
        return new EmployerBean()
                .setUuid(request.getUuid())
                .setFirstName(request.getFirstName())
                .setSecondName(request.getSecondName())
                .setThirdName(request.getThirdName())
                .setEmployerType(EmployerType.safeValueOf(request.getEmployerType()))
                .setEmploymentDate(request.getEmploymentDate())
                .setDismissalDate(request.getEmploymentDate());
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
                .setTeamUuid(employerBean.getTeamUuid());
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
