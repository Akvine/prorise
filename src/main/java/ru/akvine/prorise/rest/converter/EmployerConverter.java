package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.entities.employer.EmployerType;
import ru.akvine.prorise.rest.dto.employer.EmployerDto;
import ru.akvine.prorise.service.dto.employer.EmployerBean;

@Component
public class EmployerConverter extends BaseConverter<EmployerDto, EmployerBean> {
    @Override
    protected EmployerDto convertBeanToDto(EmployerBean employerBean) {
        Preconditions.checkNotNull(employerBean, "employerBean is null");
        return new EmployerDto()
                .setFirstName(employerBean.getFirstName())
                .setSecondName(employerBean.getSecondName())
                .setThirdName(employerBean.getThirdName())
                .setEmploymentDate(employerBean.getEmploymentDate())
                .setDismissalDate(employerBean.getDismissalDate())
                .setTeamUuid(employerBean.getTeamUuid());
    }

    @Override
    protected EmployerBean convertDtoToBean(EmployerDto employerDto) {
        Preconditions.checkNotNull(employerDto, "employerDto is null");
        return new EmployerBean()
                .setFirstName(employerDto.getFirstName())
                .setSecondName(employerDto.getSecondName())
                .setThirdName(employerDto.getThirdName())
                .setEmployerType(EmployerType.safeValueOf(employerDto.getEmploymentType()))
                .setEmploymentDate(employerDto.getEmploymentDate())
                .setDismissalDate(employerDto.getDismissalDate());
    }

    @Override
    protected EmployerBean createEmptyBean() {
        return new EmployerBean();
    }
}
