package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akvine.prorise.entities.GoalEntity;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {
}
