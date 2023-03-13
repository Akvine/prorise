package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akvine.prorise.entities.task.TaskEntity;

public interface TaskRepository extends BaseRepository<TaskEntity>, JpaRepository<TaskEntity, Long> {
}
