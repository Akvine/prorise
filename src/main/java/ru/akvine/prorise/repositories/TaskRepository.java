package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.task.TaskEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query("FROM TaskEntity te WHERE te.uuid = :uuid and te.deleted = false")
    Optional<TaskEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);

    @Query("FROM TaskEntity te WHERE te.deleted = false AND te.done = true")
    List<TaskEntity> findByCompleted();

    @Query("from TaskEntity te " +
            "where " +
            "te.deleted = false and te.deletedDate is null " +
            "and " +
            "te.done = true " +
            "and " +
            "te.employer.uuid in (:uuids) " +
            "and " +
            "te.startDate >= :startDate and te.endDate <= :endDate")
    List<TaskEntity> findAllCompletedByEmployersUuidsWithDateRange(@Param("uuids") Set<String> uuids,
                                                                   @Param("startDate") LocalDateTime startDate,
                                                                   @Param("endDate") LocalDateTime endDate);

    @Query("from TaskEntity te " +
            "where " +
            "te.deleted = false and te.deletedDate is null " +
            "and " +
            "te.employer.uuid in (:uuids) " +
            "and " +
            "te.startDate >= :startDate and te.endDate <= :endDate")
    List<TaskEntity> findAllByEmployersUuidsWithDateRange(@Param("uuids") Set<String> uuids,
                                                          @Param("startDate") LocalDateTime startDate,
                                                          @Param("endDate") LocalDateTime endDate);
}
