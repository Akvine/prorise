package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akvine.prorise.entities.GoalEntity;

public interface GoalRepository extends BaseRepository<GoalEntity>, JpaRepository<GoalEntity, Long> {
}