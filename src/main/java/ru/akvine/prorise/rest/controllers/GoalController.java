package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.BaseConverter;
import ru.akvine.prorise.rest.converter.GoalConverter;
import ru.akvine.prorise.rest.dto.goal.GoalDto;
import ru.akvine.prorise.rest.validator.BaseValidator;
import ru.akvine.prorise.rest.validator.GoalValidator;
import ru.akvine.prorise.service.BaseService;
import ru.akvine.prorise.service.GoalService;
import ru.akvine.prorise.service.dto.goal.GoalBean;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/goals")
public class GoalController extends BaseController<GoalDto, GoalBean> {
    private final GoalValidator goalValidator;
    private final GoalService goalService;
    private final GoalConverter goalConverter;

    @Override
    protected BaseValidator getValidator() {
        return goalValidator;
    }

    @Override
    protected BaseConverter getConverter() {
        return goalConverter;
    }

    @Override
    protected BaseService getService() {
        return goalService;
    }
}
