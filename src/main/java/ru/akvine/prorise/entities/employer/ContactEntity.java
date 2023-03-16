package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CONTACT")
@Accessors(chain = true)
@Data
public class ContactEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactSeq")
    @SequenceGenerator(name = "contactSeq", sequenceName = "CONTACT_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Nullable
    @Column(name = "PHONE")
    private String phone;

    @Nullable
    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employerEntity;

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
