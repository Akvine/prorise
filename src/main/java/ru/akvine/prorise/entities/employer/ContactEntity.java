package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;

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

    @Nullable
    @Column(name = "PHONE")
    private String phone;

    @Nullable
    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employerEntity;
}
