package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.TeamEntity;
import ru.akvine.prorise.entities.employer.EmployerEntity;
import ru.akvine.prorise.exceptions.EmployerEntityNotFoundException;
import ru.akvine.prorise.repositories.EmployerRepository;
import ru.akvine.prorise.service.dto.employer.EmployerBean;
import ru.akvine.prorise.tech.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerService {
    @Value("${uuid.generator.length}")
    private int uuidGeneratorLength;
    @Value("{uuid.generator.target}")
    private String uuidGeneratorTarget;

    private final EmployerRepository employerRepository;
    private final TeamService teamService;
    private final UuidGenerator uuidGenerator;

    public EmployerBean getByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "Uuid is null");
        return new EmployerBean(getEntityByUuid(uuid));
    }

    public EmployerEntity getEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return employerRepository.findByUuidAndNotDeleted(uuid)
                .orElseThrow(() -> new EmployerEntityNotFoundException(uuid));
    }

    public List<EmployerBean> get() {
        return employerRepository
                .findAll()
                .stream()
                .map(EmployerBean::new)
                .collect(Collectors.toList());
    }

    public EmployerBean create(EmployerBean employerBean) {
        Preconditions.checkNotNull(employerBean, "employerBean is null");
        Preconditions.checkNotNull(employerBean.getTeamUuid(), "employerBean.teamUuid is null");

        TeamEntity teamEntity = teamService.getEntityByUuid(employerBean.getTeamUuid());

        EmployerEntity employerEntity = new EmployerEntity()
                .setUuid(uuidGenerator.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setFirstName(employerBean.getFirstName())
                .setSecondName(employerBean.getSecondName())
                .setThirdName(employerBean.getThirdName())
                .setType(employerBean.getEmployerType())
                .setEmploymentDate(employerBean.getEmploymentDate())
                .setDismissalDate(employerBean.getDismissalDate())
                .setTeam(teamEntity);

        return new EmployerBean(employerRepository.save(employerEntity));
    }

    public EmployerBean update(EmployerBean employerBean) {
        Preconditions.checkNotNull(employerBean, "employerBean is null");
        EmployerEntity employerEntity = getEntityByUuid(employerBean.getUuid());
        employerEntity
                .setUpdatedDate(LocalDate.now())
                .setFirstName(employerBean.getFirstName())
                .setSecondName(employerBean.getSecondName())
                .setThirdName(employerBean.getThirdName())
                .setType(employerBean.getEmployerType())
                .setEmploymentDate(employerBean.getEmploymentDate())
                .setDismissalDate(employerBean.getDismissalDate());

        String teamUuid = employerBean.getTeamUuid();
        if (StringUtils.isNotBlank(teamUuid)) {
            TeamEntity teamEntity = teamService.getEntityByUuid(teamUuid);
            employerEntity.setTeam(teamEntity);
        }

        return new EmployerBean(employerRepository.save(employerEntity));
    }

    public void deleteByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        EmployerEntity employerEntity = getEntityByUuid(uuid);
        employerEntity.setDeleted(true);
        employerEntity.setDeletedDate(LocalDate.now());
        employerRepository.save(employerEntity);
    }
}
