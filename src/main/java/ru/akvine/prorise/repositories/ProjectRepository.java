package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akvine.prorise.entities.project.ProjectEntity;

public interface ProjectRepository extends BaseRepository<ProjectEntity>, JpaRepository<ProjectEntity, Long> {
}
