package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "AWARD")
@Data
@Accessors(chain = true)
public class AwardEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "awardSeq")
    @SequenceGenerator(name = "awardSeq", sequenceName = "AWARD_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "REASON")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;

    @Column(name = "RECEIPT_DATE")
    private LocalDate receiptDate;
}
