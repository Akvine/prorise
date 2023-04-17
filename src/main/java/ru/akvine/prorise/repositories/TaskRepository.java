package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.task.TaskEntity;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query("FROM TaskEntity te WHERE te.uuid = :uuid and te.deleted = false")
    Optional<TaskEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);

    @Query("FROM TaskEntity te WHERE te.deleted = false AND te.done = true")
    List<TaskEntity> findByCompleted();
}
