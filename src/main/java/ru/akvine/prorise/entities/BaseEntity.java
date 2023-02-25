package ru.akvine.prorise.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
@Accessors(chain = true)
public abstract class BaseEntity<ID> {

    @Column(name = "UUID", updatable = false, nullable = false)
    private String uuid;

    @Column(name = "CREATED_DATE", updatable = false, nullable = false)
    private LocalDate createdDate = LocalDate.now();

    @Nullable
    @Column(name = "UPDATED_DATE")
    private LocalDate updatedDate;

    @Nullable
    @Column(name = "DELETED_DATE")
    private LocalDate deletedDate;

    @Column(name = "IS_DELETED", nullable = false)
    private boolean deleted;

    public abstract ID getId();

    public void deleteRelative(LocalDate localDate) {

    }
}
