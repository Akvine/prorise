package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.department.DepartmentEntity;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.entities.department.DepartmentTypeEntity;
import ru.akvine.prorise.exceptions.BaseEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.department.DepartmentAlreadyFoundException;
import ru.akvine.prorise.exceptions.department.DepartmentNotFoundException;
import ru.akvine.prorise.exceptions.department.DepartmentTypeNotFoundException;
import ru.akvine.prorise.repositories.DepartmentRepository;
import ru.akvine.prorise.repositories.DepartmentTypeRepository;
import ru.akvine.prorise.service.dto.department.DepartmentBean;
import ru.akvine.prorise.tech.UuidGenerator;

import java.util.Optional;

@Service
public class DepartmentService extends BaseService<DepartmentBean, DepartmentEntity> {
    public DepartmentService(UuidGenerator uuidGenerator,
                             DepartmentRepository departmentRepository,
                             DepartmentTypeRepository departmentTypeRepository) {
        super(uuidGenerator);
        this.departmentRepository = departmentRepository;
        this.departmentTypeRepository = departmentTypeRepository;
    }

    private final DepartmentRepository departmentRepository;
    private final DepartmentTypeRepository departmentTypeRepository;

    @Override
    protected BaseRepository<DepartmentEntity> getRepository() {
        return departmentRepository;
    }

    @Override
    protected DepartmentEntity createEmptyEntity() {
        return new DepartmentEntity();
    }

    @Override
    protected DepartmentBean convertEntityToBean(DepartmentEntity entity) {
        return new DepartmentBean(entity);
    }

    @Override
    protected DepartmentEntity convertBeanToEntity(DepartmentBean bean, DepartmentEntity entity) {
        Preconditions.checkNotNull(bean, "departmentBean is null");
        Preconditions.checkNotNull(entity, "departmentEntity is null");

        DepartmentType type = bean.getType();
        Optional<DepartmentTypeEntity> typeEntityOptional = departmentTypeRepository.getByType(type);
        DepartmentTypeEntity departmentTypeEntity;

        if (typeEntityOptional.isPresent()) {
            departmentTypeEntity = typeEntityOptional.get();
        } else {
            throw new DepartmentTypeNotFoundException(type.toString());
        }

        return new DepartmentEntity()
                .setTitle(bean.getTitle())
                .setDescription(bean.getDescription())
                .setDepartmentType(departmentTypeEntity);
    }

    @Override
    protected DepartmentNotFoundException createNotFoundException(String uuid) {
        return new DepartmentNotFoundException(uuid);
    }

    @Override
    protected BaseEntityAlreadyFoundException createAlreadyFoundException(DepartmentBean bean) {
        return new DepartmentAlreadyFoundException(bean);
    }
}
