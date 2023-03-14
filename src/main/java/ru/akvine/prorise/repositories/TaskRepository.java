package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.task.TaskEntity;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query("from TaskEntity te where te.done = true " +
            "and te.deleted = false " +
            "and te.startedDate = :startedDate " +
            "and te.endDate = :endDate " +
            "and te.employer.uuid = :uuid")
    List<TaskEntity> getCompletedByPeriodDateAndEmployerUuid(@Param("startedDate") LocalDate startedDate,
                                                             @Param("endDate") LocalDate endDate,
                                                             @Param("uuid") String employerUuid);

    @Query("from TaskEntity te where te.done = true " +
            "and te.deleted = false " +
            "and te.startedDate >= :startedDate " +
            "and te.endDate <= :endDate")
    List<TaskEntity> getCompletedByPeriodDate(@Param("startedDate") LocalDate startedDate,
                                              @Param("endDate") LocalDate endDate);

    @Query("from TaskEntity te where te.done = true and te.deleted = false")
    List<TaskEntity> getCompleted();
}
