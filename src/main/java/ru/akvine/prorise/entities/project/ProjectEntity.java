package ru.akvine.prorise.entities.project;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.BaseEntity;
import ru.akvine.prorise.entities.GoalEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "PROJECT")
@Data
@Accessors(chain = true)
public class ProjectEntity extends BaseEntity<Long> {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSeq")
    @SequenceGenerator(name = "projectSeq", sequenceName = "PROJECT_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "STARTED_DATE", nullable = false)
    private LocalDate startedDate;

    @Nullable
    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Nullable
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PROJECT_TYPE")
    @Enumerated(EnumType.STRING)
    private ProjectType type;

    @OneToMany
    @JoinColumn(name = "GOAL_ID", nullable = false)
    private List<GoalEntity> goals;

    @Column(name = "IS_DONE", nullable = false)
    private boolean done;
}
