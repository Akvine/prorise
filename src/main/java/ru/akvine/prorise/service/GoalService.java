package ru.akvine.prorise.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.exceptions.goal.GoalEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.goal.GoalEntityNotFoundException;
import ru.akvine.prorise.repositories.GoalRepository;
import ru.akvine.prorise.service.dto.goal.GoalBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
}
