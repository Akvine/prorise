package ru.akvine.prorise.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.employer.EmployerEntity;
import ru.akvine.prorise.entities.project.ProjectEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEAM")
@Data
@Accessors(chain = true)
public class TeamEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamSeq")
    @SequenceGenerator(name = "teamSeq", sequenceName = "TEAM_SEQUENCE", allocationSize = 1000)
    private Long id;

    @OneToMany
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private List<EmployerEntity> employers;

    @OneToMany
    @JoinColumn(name = "TEAM_ID", nullable = false)
    private List<ProjectEntity> projects;

    @Nullable
    @Column(name = "DESCRIPTION")
    private String description;
}
