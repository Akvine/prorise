package ru.akvine.prorise.entities.department;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

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

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private DepartmentType type;
}
