package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akvine.prorise.entities.department.DepartmentEntity;

public interface DepartmentRepository extends BaseRepository<DepartmentEntity>, JpaRepository<DepartmentEntity, Long> {
}
