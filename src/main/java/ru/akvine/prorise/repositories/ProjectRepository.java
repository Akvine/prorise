package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.akvine.prorise.entities.project.ProjectEntity;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    @Query("FROM ProjectEntity pe WHERE pe.uuid = :uuid and pe.deleted = false")
    Optional<ProjectEntity> findByUuidAndNotDeleted(@Param("uuid") String uuid);
}
