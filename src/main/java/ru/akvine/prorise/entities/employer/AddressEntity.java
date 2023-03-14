package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

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

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @OneToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;
}
