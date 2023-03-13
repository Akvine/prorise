package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.employer.EmployerEntity;
import ru.akvine.prorise.exceptions.employer.EmployerEntityAlreadyFoundException;
import ru.akvine.prorise.exceptions.employer.EmployerEntityNotFoundException;
import ru.akvine.prorise.repositories.BaseRepository;
import ru.akvine.prorise.repositories.EmployerRepository;
import ru.akvine.prorise.service.dto.employer.EmployerBean;
import ru.akvine.prorise.tech.UuidGenerator;

@Service
public class EmployerService extends BaseService<EmployerBean, EmployerEntity> {
    public EmployerService(UuidGenerator uuidGenerator, EmployerRepository employerRepository) {
        super(uuidGenerator);
        this.employerRepository = employerRepository;
    }

    private final EmployerRepository employerRepository;

    @Override
    protected BaseRepository<EmployerEntity> getRepository() {
        return employerRepository;
    }

    @Override
    protected EmployerEntity createEmptyEntity() {
        return new EmployerEntity();
    }

    @Override
    protected EmployerBean convertEntityToBean(EmployerEntity entity) {
        return new EmployerBean(entity);
    }

    @Override
    protected EmployerEntity convertBeanToEntity(EmployerBean bean, EmployerEntity entity) {
        Preconditions.checkNotNull(bean, "employerBean is null");
        Preconditions.checkNotNull(entity, "employerEntity is null");

        return new EmployerEntity()
                .setFirstName(bean.getFirstName())
                .setSecondName(bean.getSecondName())
                .setThirdName(bean.getThirdName())
                .setEmploymentDate(bean.getEmploymentDate())
                .setDismissalDate(bean.getDismissalDate())
                .setType(bean.getEmployerType());
    }

    @Override
    protected EmployerEntityNotFoundException createNotFoundException(String uuid) {
        return new EmployerEntityNotFoundException(uuid);
    }

    @Override
    protected EmployerEntityAlreadyFoundException createAlreadyFoundException(EmployerBean bean) {
        return new EmployerEntityAlreadyFoundException(bean);
    }
}
