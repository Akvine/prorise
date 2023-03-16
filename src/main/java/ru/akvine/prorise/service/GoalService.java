package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.GoalEntity;
import ru.akvine.prorise.exceptions.GoalEntityNotFoundException;
import ru.akvine.prorise.repositories.GoalRepository;
import ru.akvine.prorise.service.dto.goal.GoalBean;
import ru.akvine.prorise.tech.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalService {
    private final GoalRepository goalRepository;
    private final UuidGenerator uuidGenerator;

    @Value("${uuid.generator.length}")
    private int uuidGeneratorLength;
    @Value("{uuid.generator.target}")
    private String uuidGeneratorTarget;


    public GoalBean getByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "Uuid is null");
        return new GoalBean(getEntityByUuid(uuid));
    }

    public GoalEntity getEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return goalRepository.findByUuidAndNotDeleted(uuid)
                .orElseThrow(() -> new GoalEntityNotFoundException("GoalEntity not found by uuid = " + uuid));
    }

    public List<GoalBean> get() {
        return goalRepository
                .findAll()
                .stream()
                .map(GoalBean::new)
                .collect(Collectors.toList());
    }

    public GoalBean create(GoalBean goalBean) {
        Preconditions.checkNotNull(goalBean, "goalBean is null");

        GoalEntity goalEntity = new GoalEntity()
                .setUuid(uuidGenerator.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(goalBean.getTitle())
                .setDescription(goalBean.getDescription());

        return new GoalBean(goalRepository.save(goalEntity));
    }

    public GoalBean update(GoalBean goalBean) {
        Preconditions.checkNotNull(goalBean, "goalBean is null");
        GoalEntity goalEntity = getEntityByUuid(goalBean.getUuid());
        goalEntity
                .setTitle(goalBean.getTitle())
                .setDescription(goalBean.getDescription())
                .setDone(goalBean.isDone())
                .setUpdatedDate(LocalDate.now());

        return new GoalBean(goalRepository.save(goalEntity));
    }

    public void deleteByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        GoalEntity goalEntity = getEntityByUuid(uuid);
        goalEntity.setDeleted(true);
        goalEntity.setDeletedDate(LocalDate.now());
        goalRepository.save(goalEntity);
    }
}
