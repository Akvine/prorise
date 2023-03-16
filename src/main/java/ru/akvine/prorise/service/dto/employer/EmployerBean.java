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
    private Long id;
    private String uuid;
    private String firstName;
    private String secondName;
    @Nullable
    private String thirdName;
    private LocalDate createdDate;
    @Nullable
    private LocalDate updatedDate;
    @Nullable
    private LocalDate deletedDate;
    private boolean deleted;
    @Nullable
    private String teamUuid;
    private LocalDate employmentDate;
    @Nullable
    private LocalDate dismissalDate;
    private EmployerType employerType;

    public EmployerBean(EmployerEntity employerEntity) {
        this.id = employerEntity.getId();
        this.uuid = employerEntity.getUuid();
        this.firstName = employerEntity.getFirstName();
        this.secondName = employerEntity.getSecondName();
        this.thirdName = employerEntity.getThirdName();
        this.createdDate = employerEntity.getCreatedDate();
        this.updatedDate = employerEntity.getUpdatedDate();
        this.deletedDate = employerEntity.getDeletedDate();
        this.deleted = employerEntity.isDeleted();
        this.employmentDate = employerEntity.getEmploymentDate();
        this.dismissalDate = employerEntity.getDismissalDate();
        this.employerType = employerEntity.getType();
    }
}
