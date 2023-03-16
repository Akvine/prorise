package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.EmployerControllerMeta;
import ru.akvine.prorise.rest.converter.EmployerConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.dto.employer.EmployerCreateRequest;
import ru.akvine.prorise.rest.dto.employer.EmployerUpdateRequest;
import ru.akvine.prorise.rest.validator.EmployerValidator;
import ru.akvine.prorise.service.EmployerService;
import ru.akvine.prorise.service.dto.employer.EmployerBean;

import java.util.List;

@RestController
@RequestMapping(value = "/employers")
@RequiredArgsConstructor
public class EmployerController implements EmployerControllerMeta {
    private final EmployerConverter employerConverter;
    private final EmployerValidator employerValidator;
    private final EmployerService employerService;

    @Override
    public Response get() {
        List<EmployerBean> employers = employerService.get();
        return employerConverter.convertToEmployerListResponse(employers);
    }

    @Override
    public Response getByUuid(String uuid) {
        EmployerBean employerBean = employerService.getByUuid(uuid);
        return employerConverter.convertToEmployerResponse(employerBean);
    }

    @Override
    public Response create(EmployerCreateRequest request) {
        EmployerBean employerBean = employerConverter.convertToEmployerBean(request);
        EmployerBean createdBean = employerService.create(employerBean);
        return employerConverter.convertToEmployerResponse(createdBean);
    }

    @Override
    public Response update(EmployerUpdateRequest request) {
        EmployerBean employerBean = employerConverter.convertToEmployerBean(request);
        EmployerBean updatedBean = employerService.update(employerBean);
        return employerConverter.convertToEmployerResponse(updatedBean);
    }

    @Override
    public Response delete(String uuid) {
        employerService.getByUuid(uuid);
        return new SuccessfulResponse();
    }
}
