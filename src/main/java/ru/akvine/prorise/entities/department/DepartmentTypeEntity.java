package ru.akvine.prorise.entities.department;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DEPARTMENT_TYPE")
@Data
@Accessors(chain = true)
public class DepartmentTypeEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentTypeSeq")
    @SequenceGenerator(name = "departmentTypeSeq", sequenceName = "DEPARTMENT_TYPE_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private DepartmentType type;

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
