package ru.akvine.prorise.service.dto.employer;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.employer.EmployerEntity;
import ru.akvine.prorise.entities.employer.EmployerType;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class EmployerBean {
    private String firstName;
    private String secondName;
    @Nullable
    private String thirdName;
    @Nullable
    private String teamUuid;
    private LocalDate employmentDate;
    @Nullable
    private LocalDate dismissalDate;
    private EmployerType employerType;

    public EmployerBean(EmployerEntity employerEntity) {
        super(employerEntity);
        this.firstName = employerEntity.getFirstName();
        this.secondName = employerEntity.getSecondName();
        this.thirdName = employerEntity.getThirdName();
        this.employmentDate = employerEntity.getEmploymentDate();
        this.dismissalDate = employerEntity.getDismissalDate();
        this.employerType = employerEntity.getType();
    }
}
