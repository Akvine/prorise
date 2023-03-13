package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import ru.akvine.prorise.entities.BaseEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.BaseEntityNotFoundException;
import ru.akvine.prorise.repositories.BaseRepository;
import ru.akvine.prorise.service.dto.BaseBean;
import ru.akvine.prorise.service.dto.BaseFilter;
import ru.akvine.prorise.tech.UuidGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class BaseService<B extends BaseBean, E extends BaseEntity> {
    private final UuidGenerator uuidGenerator;

    @Value("${uuid.generator.length}")
    private int length;
    @Value("${uuid.generator.target}")
    private String target;

    public <F extends BaseFilter> List<B> list(F filter) {
        Preconditions.checkNotNull(filter, "filter is null");
        return findEntityList(filter)
                .stream()
                .map(this::convertEntityToBean)
                .collect(Collectors.toList());
    }

    public B get(B bean) {
        Preconditions.checkNotNull(bean, "bean is null");
        Preconditions.checkNotNull(bean.getUuid(), "bean.uuid is null");

        E entity = getEntityByUuid(bean.getUuid());
        return convertEntityToBean(entity);
    }

    public B create(B bean) {
        Preconditions.checkNotNull(bean, "bean is null");

        getEntityByParams(bean).ifPresent(entity -> {
            throw createAlreadyFoundException(bean);
        });

        E entityToSave = createEmptyEntity();
        entityToSave = convertBeanToEntity(bean, entityToSave);

        entityToSave.setUuid(generateUuid());

        entityToSave = getRepository().save(entityToSave);
        return convertEntityToBean(entityToSave);
    }

    public B update(B bean) {
        Preconditions.checkNotNull(bean, "bean is null");
        Preconditions.checkNotNull(bean.getUuid(), "bean.uuid is null");

        E entityToUpdate = getEntityByUuid(bean.getUuid());

        Object entityToUpdateId = entityToUpdate.getUuid();
        getEntityByParams(bean).ifPresent(entityExisted -> {
            if (!entityExisted.getId().equals(entityToUpdateId)) {
                throw createAlreadyFoundException(bean);
            }
        });

        entityToUpdate = convertBeanToEntity(bean, entityToUpdate);
        entityToUpdate.setUpdatedDate(LocalDate.now());

        entityToUpdate = getRepository().save(entityToUpdate);

        return convertEntityToBean(entityToUpdate);
    }

    @Transactional
    public void delete(B bean) {
        Preconditions.checkNotNull(bean, "bean is null");
        Preconditions.checkNotNull(bean.getUuid(), "bean.uuid is null");

        LocalDate deletedDate = LocalDate.now();

        E entity = getEntityByUuid(bean.getUuid());
        entity.setDeleted(true);
        entity.setDeletedDate(deletedDate);
        entity.deleteRelative(deletedDate);

        getRepository().save(entity);
    }

    protected List<E> findEntityList(BaseFilter filter) {
        Preconditions.checkNotNull(filter, "filter is null");

        return getRepository().findByDeletedIsFalse();
    }

    protected E getEntityByUuid(String uuid) {
        return getRepository()
                .findByUuidAndDeletedIsFalse(uuid)
                .orElseThrow(() -> createNotFoundException(uuid));
    }

    protected Optional<E> getEntityByParams(B bean) {
        return Optional.empty();
    }

    protected abstract BaseRepository<E> getRepository();

    protected abstract E createEmptyEntity();
    protected  abstract B convertEntityToBean(E entity);
    protected abstract E convertBeanToEntity(B bean, E entity);

    protected abstract BaseEntityNotFoundException createNotFoundException(String uuid);
    protected abstract BaseEntityAlreadyFoundException createAlreadyFoundException(B bean);

    protected String generateUuid() {
        return uuidGenerator.generate(length, target);
    }
}
