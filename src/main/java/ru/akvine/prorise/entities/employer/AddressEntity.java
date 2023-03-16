package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ADDRESS")
@Accessors(chain = true)
@Data
public class AddressEntity {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressSeq")
    @SequenceGenerator(name = "addressSeq", sequenceName = "ADDRESS_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @OneToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;

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
