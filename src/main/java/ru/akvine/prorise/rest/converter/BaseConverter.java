package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import ru.akvine.prorise.rest.dto.*;
import ru.akvine.prorise.service.dto.BaseBean;
import ru.akvine.prorise.service.dto.BaseFilter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseConverter<D extends BaseDto, B extends BaseBean> {
    public BaseFilter convertToBaseFilter() {
        return new BaseFilter();
    }

    public B convertRequestToBean(UuidRequest request) {
        Preconditions.checkNotNull(request, "UuidRequest is null");

        B bean = createEmptyBean();
        bean.setUuid(request.getUuid());
        return bean;
    }

    public B convertRequestToBean(DtoRequest<D> request) {
        Preconditions.checkNotNull(request, "DtoRequest is null");

        B bean = convertDtoToBean(request.getDto());
        bean.setUuid(request.getDto().getUuid());
        return bean;
    }

    public ListResponse<D> convertToListResponse(List<B> list) {
        Preconditions.checkNotNull(list, "list is null");

        List<D> dtoList = list
                .stream()
                .map(this::convertBaseBeanToDto)
                .collect(Collectors.toList());
        return new ListResponse().setList(dtoList);
    }

    public DtoResponse<D> convertDtoToResponse(B bean) {
        Preconditions.checkNotNull(bean, "bean is null");
        D dto = convertBaseBeanToDto(bean);
        return new DtoResponse().setDto(dto);
    }

    private D convertBaseBeanToDto(B bean) {
        Preconditions.checkNotNull(bean, "bean is null");

        D dto = convertBeanToDto(bean);
        dto.setUuid(bean.getUuid());
        dto.setCreatedDate(bean.getCreatedDate());
        dto.setUpdatedDate(bean.getUpdatedDate());
        return dto;
    }

    protected abstract D convertBeanToDto(B bean);
    protected abstract B convertDtoToBean(D dto);
    protected abstract B createEmptyBean();
}
