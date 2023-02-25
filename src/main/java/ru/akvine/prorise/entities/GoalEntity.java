package ru.akvine.prorise.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.entities.task.TaskEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "GOAL")
@Data
@Accessors(chain = true)
public class GoalEntity extends BaseEntity<Long> {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goalSeq")
    @SequenceGenerator(name = "goalSeq", sequenceName = "GOAL_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @OneToMany
    @JoinColumn(name = "GOAL_ID", nullable = false)
    private List<TaskEntity> tasks;

    @Column(name = "IS_DONE", nullable = false)
    private boolean done;
}
