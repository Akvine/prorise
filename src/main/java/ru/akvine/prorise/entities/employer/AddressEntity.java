package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.akvine.prorise.entities.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Accessors(chain = true)
@Data
public class AddressEntity extends BaseEntity<Long> {
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressSeq")
    @SequenceGenerator(name = "addressSeq", sequenceName = "ADDRESS_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "COUNTRY", nullable = false)
    private String country;
}
