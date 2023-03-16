package ru.akvine.prorise.entities.project;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.TeamEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PROJECT")
@Data
@Accessors(chain = true)
public class ProjectEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectSeq")
    @SequenceGenerator(name = "projectSeq", sequenceName = "PROJECT_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "TITLE", nullable = false)
    private String title;

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

    @ManyToOne
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private TeamEntity team;

    @Column(name = "IS_DONE", nullable = false)
    private boolean done;

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
