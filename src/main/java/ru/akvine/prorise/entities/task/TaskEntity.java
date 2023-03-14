package ru.akvine.prorise.entities.task;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.employer.EmployerEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TASK")
@Data
@Accessors(chain = true)
public class TaskEntity extends BaseEntity<Long> {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskSeq")
    @SequenceGenerator(name = "taskSeq", sequenceName = "TASK_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "STARTED_DATE", nullable = false)
    private LocalDate startedDate;

    @Nullable
    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "PRIORITY_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private PriorityType priority;

    @OneToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "IS_DONE", nullable = false)
    private boolean done;
}
