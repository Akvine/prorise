package ru.akvine.prorise.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.project.ProjectEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "GOAL")
@Data
@Accessors(chain = true)
public class GoalEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goalSeq")
    @SequenceGenerator(name = "goalSeq", sequenceName = "GOAL_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", nullable = false)
    private ProjectEntity project;

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
