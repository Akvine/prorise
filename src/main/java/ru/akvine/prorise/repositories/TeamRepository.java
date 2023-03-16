package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.entities.task.TaskEntity;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
    @Query("FROM TeamEntity te WHERE te.uuid = :uuid and te.deleted = false")
    Optional<TeamEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);
}
