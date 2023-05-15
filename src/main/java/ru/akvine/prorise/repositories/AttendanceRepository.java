package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.employer.AttendanceEntity;

import java.util.List;
import java.util.Set;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
    @Query("from AttendanceEntity ae " +
            "where ae.employer in (:uuids) " +
            "and " +
            "ae.employer.deleted = false and ae.employer.deletedDate is null")
    List<AttendanceEntity> findByEmployersUuids(@Param("uuids") Set<String> uuids);
}
