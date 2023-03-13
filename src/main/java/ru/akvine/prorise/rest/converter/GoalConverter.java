package ru.akvine.prorise.rest.converter;

import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.goal.GoalDto;
import ru.akvine.prorise.service.dto.goal.GoalBean;

@Component
public class GoalConverter extends BaseConverter<GoalDto, GoalBean> {
    @Override
    protected GoalDto convertBeanToDto(GoalBean bean) {
        return null;
    }

    @Override
    protected GoalBean convertDtoToBean(GoalDto dto) {
        return null;
    }

    @Override
    protected GoalBean createEmptyBean() {
        return null;
    }
}
