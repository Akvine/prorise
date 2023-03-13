package ru.akvine.prorise.entities.department;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;
import ru.akvine.prorise.entities.BaseEntity;
import ru.akvine.prorise.entities.TeamEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
@Data
@Accessors(chain = true)
public class DepartmentEntity extends BaseEntity<Long> {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSeq")
    @SequenceGenerator(name = "departmentSeq", sequenceName = "DEPARTMENT_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_TYPE_ID", nullable = false)
    private DepartmentTypeEntity departmentType;

    @Nullable
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany
    @JoinColumn(name = "DEPARTMENT_ID", nullable = false)
    private List<TeamEntity> teams;
}
