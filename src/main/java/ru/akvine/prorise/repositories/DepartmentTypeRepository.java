package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.entities.department.DepartmentTypeEntity;

import java.util.Optional;

public interface DepartmentTypeRepository extends BaseRepository<DepartmentTypeEntity>, JpaRepository<DepartmentTypeEntity, Long> {
    @Query("from DepartmentTypeEntity dte where dte.type = :type and dte.deleted = false")
    Optional<DepartmentTypeEntity> getByType(@Param("type")DepartmentType type);
}
