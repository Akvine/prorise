package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "EMPLOYER")
@Accessors(chain = true)
@Data
public class EmployerEntity extends BaseEntity<Long> {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employerSeq")
    @SequenceGenerator(name = "employerSeq", sequenceName = "EMPLOYER_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "SECOND_NAME", nullable = false)
    private String secondName;

    @Nullable
    @Column(name = "THIRD_NAME")
    private String thirdName;

    @Column(name = "EMPLOYMENT_DATE", nullable = false, updatable = false)
    private LocalDate employmentDate;

    @Nullable
    @Column(name = "DISMISSAL_DATE")
    private LocalDate dismissalDate;

    @Column(name = "EMPLOYER_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private EmployerType type;
}
