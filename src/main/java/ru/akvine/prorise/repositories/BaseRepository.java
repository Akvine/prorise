package ru.akvine.prorise.repositories;

import ru.akvine.prorise.entities.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity> {
    E save(E var1);

    List<E> findByDeletedIsFalse();

    Optional<E> findByUuid(String uuid);

    Optional<E> findByUuidAndDeletedIsFalse(String uuid);

    void delete(E entity);
}
