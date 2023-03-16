package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.GoalEntity;

import java.util.Optional;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {
    @Query("FROM GoalEntity ge WHERE ge.uuid = :uuid and ge.deleted = false")
    Optional<GoalEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);
}
