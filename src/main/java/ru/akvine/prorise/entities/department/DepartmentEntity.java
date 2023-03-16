package ru.akvine.prorise.entities.department;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DEPARTMENT")
@Data
@Accessors(chain = true)
public class DepartmentEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSeq")
    @SequenceGenerator(name = "departmentSeq", sequenceName = "DEPARTMENT_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "DEPARTMENT_TYPE_ID", nullable = false)
    private DepartmentTypeEntity departmentType;

    @Nullable
    @Column(name = "DESCRIPTION")
    private String description;

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
