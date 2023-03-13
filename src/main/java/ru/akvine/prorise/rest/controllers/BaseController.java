package ru.akvine.prorise.rest.controllers;

import org.springframework.web.bind.annotation.*;
import ru.akvine.prorise.rest.converter.BaseConverter;
import ru.akvine.prorise.rest.dto.BaseDto;
import ru.akvine.prorise.rest.dto.DtoRequest;
import ru.akvine.prorise.rest.dto.UuidRequest;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.validator.BaseValidator;
import ru.akvine.prorise.service.BaseService;
import ru.akvine.prorise.service.dto.BaseBean;
import ru.akvine.prorise.service.dto.BaseFilter;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseController<D extends BaseDto, B extends BaseBean> {

    @GetMapping
    public Response list() {
        BaseFilter filter = getConverter().convertToBaseFilter();
        List<B> list = getService().list(filter);
        return getConverter().convertToListResponse(list);
    }

    @GetMapping(value = "/get")
    public Response get(@RequestBody @Valid UuidRequest request) {
        BaseBean beanToGet = getConverter().convertRequestToBean(request);
        BaseBean bean = getService().get(beanToGet);
        return getConverter().convertDtoToResponse(bean);
    }

    @PostMapping
    public Response create(@RequestBody @Valid DtoRequest<D> request) {
        getValidator().validateCreateRequest(request);
        BaseBean beanToCreate = getConverter().convertRequestToBean(request);
        beanToCreate = getService().create(beanToCreate);
        return getConverter().convertDtoToResponse(beanToCreate);
    }

    @PutMapping
    public Response update(@RequestBody @Valid DtoRequest<D> request) {
        getValidator().validateCreateRequest(request);
        BaseBean beanToUpdate = getConverter().convertRequestToBean(request);
        beanToUpdate = getService().update(beanToUpdate);
        return getConverter().convertDtoToResponse(beanToUpdate);
    }

    @DeleteMapping
    public Response delete(@RequestBody @Valid UuidRequest request) {
        BaseBean beanToDelete = getConverter().convertRequestToBean(request);
        getService().delete(beanToDelete);
        return new SuccessfulResponse();
    }

    protected abstract BaseValidator getValidator();
    protected abstract BaseConverter getConverter();
    protected abstract BaseService getService();
}
