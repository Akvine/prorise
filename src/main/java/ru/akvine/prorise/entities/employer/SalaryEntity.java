package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "SALARY")
@Data
@Accessors(chain = true)
public class SalaryEntity extends BaseEntity<Long> {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salarySeq")
    @SequenceGenerator(name = "salarySeq", sequenceName = "SALARY_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "SALARY", nullable = false)
    private Long salary;

    @Column(name = "CURRENCY_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @OneToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;
}
