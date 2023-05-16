package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.department.DepartmentEntity;
import ru.akvine.prorise.entities.department.DepartmentType;
import ru.akvine.prorise.entities.department.DepartmentTypeEntity;
import ru.akvine.prorise.exceptions.DepartmentNotFoundException;
import ru.akvine.prorise.exceptions.DepartmentTypeNotFoundException;
import ru.akvine.prorise.repositories.DepartmentRepository;
import ru.akvine.prorise.repositories.DepartmentTypeRepository;
import ru.akvine.prorise.service.dto.department.DepartmentBean;
import ru.akvine.prorise.utils.UuidGeneratorUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentTypeRepository departmentTypeRepository;
    private final UuidGeneratorUtils uuidGeneratorUtils;

    @Value("${uuid.generator.length}")
    private int uuidGeneratorLength;
    @Value("{uuid.generator.target}")
    private String uuidGeneratorTarget;


    public DepartmentBean getByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "Uuid is null");
        return new DepartmentBean(getEntityByUuid(uuid));
    }

    public DepartmentEntity getEntityByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        return departmentRepository.findByUuidAndNotDeleted(uuid)
                .orElseThrow(() -> new DepartmentNotFoundException("DepartmentEntity not found by uuid = " + uuid));
    }

    public List<DepartmentBean> get() {
        return departmentRepository
                .findAll()
                .stream()
                .map(DepartmentBean::new)
                .collect(Collectors.toList());
    }

    public DepartmentBean create(DepartmentBean departmentBean) {
        Preconditions.checkNotNull(departmentBean, "departmentBean is null");

        DepartmentType type = departmentBean.getType();
        DepartmentTypeEntity entity = new DepartmentTypeEntity()
                .setUuid(uuidGeneratorUtils.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setDescription("some description")
                .setCode("some code")
                .setType(DepartmentType.HR);
        departmentTypeRepository.save(entity);
//        DepartmentTypeEntity departmentTypeEntity = departmentTypeRepository.getByType(type)
//                .orElseThrow(() -> new DepartmentTypeNotFoundException("DepartmentType not found by type = " + type.name()));
        DepartmentEntity departmentEntity = new DepartmentEntity()
                .setUuid(uuidGeneratorUtils.generate(uuidGeneratorLength, uuidGeneratorTarget))
                .setTitle(departmentBean.getTitle())
                .setDescription(departmentBean.getDescription())
                .setDepartmentType(entity);

        DepartmentEntity departmentEntity1 = departmentRepository.save(departmentEntity);
        return new DepartmentBean(departmentEntity1);
    }

    public DepartmentBean update(DepartmentBean departmentBean) {
        Preconditions.checkNotNull(departmentBean, "departmentBean is null");
        DepartmentEntity departmentEntity = getEntityByUuid(departmentBean.getUuid());

        String title = departmentBean.getTitle();
        String description = departmentBean.getDescription();

        if (StringUtils.isNotBlank(title)) {
            departmentEntity.setTitle(title);
        }
        if (StringUtils.isNotBlank(description)) {
            departmentEntity.setDescription(description);
        }

        DepartmentType departmentType = departmentBean.getType();
        if (departmentType != null) {
            DepartmentTypeEntity departmentTypeEntity = departmentTypeRepository
                    .getByType(departmentType)
                    .orElseThrow(() -> new DepartmentTypeNotFoundException("Type not found by = " + departmentType));
            departmentEntity.setDepartmentType(departmentTypeEntity);
        }

        departmentEntity
                .setUpdatedDate(LocalDate.now());
        DepartmentEntity departmentEntity1 = departmentRepository.save(departmentEntity);
        return new DepartmentBean(departmentEntity1);
    }

    public DepartmentBean patch(DepartmentBean employerBean) {
        Preconditions.checkNotNull(employerBean, "departmentBean is null");
        DepartmentEntity departmentEntity = getEntityByUuid(employerBean.getUuid());
        departmentEntity
                .setTitle(employerBean.getTitle())
                .setDescription(employerBean.getDescription())
                .setUpdatedDate(LocalDate.now());

        return new DepartmentBean(departmentRepository.save(departmentEntity));
    }

    public void deleteByUuid(String uuid) {
        Preconditions.checkNotNull(uuid, "uuid is null");
        DepartmentEntity departmentEntity = getEntityByUuid(uuid);
        departmentEntity.setDeleted(true);
        departmentEntity.setDeletedDate(LocalDate.now());
        departmentRepository.save(departmentEntity);
    }
}
