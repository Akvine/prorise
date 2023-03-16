package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

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

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

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
