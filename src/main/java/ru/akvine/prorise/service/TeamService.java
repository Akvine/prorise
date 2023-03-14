package ru.akvine.prorise.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.team.TeamEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.team.TeamEntityNotFoundException;
import ru.akvine.prorise.repositories.TeamRepository;
import ru.akvine.prorise.service.dto.team.TeamBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final UuidGenerator uuidGenerator;
}
