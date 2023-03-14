package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

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
}
