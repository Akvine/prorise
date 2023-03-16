package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SALARY")
@Data
@Accessors(chain = true)
public class SalaryEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salarySeq")
    @SequenceGenerator(name = "salarySeq", sequenceName = "SALARY_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "SALARY", nullable = false)
    private Long salary;

    @Column(name = "CURRENCY_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @OneToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDate createdDate = LocalDate.now();

    @Nullable
    @Column(name = "UPDATED_DATE")
    private LocalDate updatedDate;

    @Nullable
    @Column(name = "DELETED_DATE")
    private LocalDate deletedDate;

    @Column(name = "IS_DELETED", nullable = false)
    private boolean deleted;
}
