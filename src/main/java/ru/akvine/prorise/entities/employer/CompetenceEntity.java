package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "COMPETENCE")
@Data
@Accessors(chain = true)
public class CompetenceEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competenceSeq")
    @SequenceGenerator(name = "competenceSeq", sequenceName = "COMPETENCE_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "EXPERIENCE", nullable = false)
    private Long experience;

    @Column(name = "TECHNOLOGY")
    private String technology;

    @Column(name = "TYPE", nullable = false)
    private CompetencyType type;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean active;

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
