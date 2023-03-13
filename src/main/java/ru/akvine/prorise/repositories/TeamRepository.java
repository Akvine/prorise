package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akvine.prorise.entities.TeamEntity;

public interface TeamRepository extends BaseRepository<TeamEntity>, JpaRepository<TeamEntity, Long> {
}
