package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TRAINING")
@Accessors(chain = true)
public class TrainingEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainingSeq")
    @SequenceGenerator(name = "trainingSeq", sequenceName = "TRAINING_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Nullable
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE", nullable = false)
    private Long price;

    @Column(name = "CURRENCY_TYPE", nullable = false)
    private CurrencyType currencyType;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employerEntity;
}
