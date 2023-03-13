package ru.akvine.prorise.service.dto.employer;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.employer.EmployerEntity;
import ru.akvine.prorise.entities.employer.EmployerType;
import ru.akvine.prorise.service.dto.BaseBean;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class EmployerBean  extends BaseBean<Long> {
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
