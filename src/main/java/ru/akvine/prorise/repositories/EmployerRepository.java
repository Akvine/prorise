package ru.akvine.prorise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.akvine.prorise.entities.employer.EmployerEntity;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Long> {
}
