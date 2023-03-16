package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.GoalControllerMeta;
import ru.akvine.prorise.rest.converter.GoalConverter;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.rest.dto.goal.GoalCreateRequest;
import ru.akvine.prorise.rest.dto.goal.GoalUpdateRequest;
import ru.akvine.prorise.rest.validator.GoalValidator;
import ru.akvine.prorise.service.GoalService;
import ru.akvine.prorise.service.dto.goal.GoalBean;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/goals")
public class GoalController implements GoalControllerMeta {
    private final GoalValidator goalValidator;
    private final GoalService goalService;
    private final GoalConverter goalConverter;

    @Override
    public Response get() {
        List<GoalBean> goals = goalService.get();
        return goalConverter.convertToGoalListResponse(goals);
    }

    @Override
    public Response getByUuid(String uuid) {
        GoalBean goalBean = goalService.getByUuid(uuid);
        return goalConverter.convertToGoalResponse(goalBean);
    }

    @Override
    public Response create(GoalCreateRequest request) {
        GoalBean goalBean = goalConverter.convertToGoalBean(request);
        GoalBean createdGoal = goalService.create(goalBean);
        return goalConverter.convertToGoalResponse(createdGoal);
    }

    @Override
    public Response update(GoalUpdateRequest request) {
        GoalBean goalBean = goalConverter.convertToGoalBean(request);
        GoalBean updatedBean = goalService.update(goalBean);
        return goalConverter.convertToGoalResponse(updatedBean);
    }

    @Override
    public Response deleteByUuid(String uuid) {
        goalService.deleteByUuid(uuid);
        return new SuccessfulResponse();
    }
}
