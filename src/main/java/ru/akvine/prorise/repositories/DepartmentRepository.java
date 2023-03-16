package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.department.DepartmentEntity;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    @Query("FROM DepartmentEntity de WHERE de.uuid = :uuid and de.deleted = false")
    Optional<DepartmentEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);
}
