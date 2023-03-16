package ru.akvine.prorise.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.repositories.GoalRepository;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
}
