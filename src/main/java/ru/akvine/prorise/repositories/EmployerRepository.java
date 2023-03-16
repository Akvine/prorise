package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.employer.EmployerEntity;

import java.util.Optional;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {

    @Query("FROM EmployerEntity ee WHERE ee.uuid = :uuid and ee.deleted = false")
    Optional<EmployerEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);
}
