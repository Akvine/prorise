package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.goal.GoalCreateRequest;
import ru.akvine.prorise.rest.dto.goal.GoalListResponse;
import ru.akvine.prorise.rest.dto.goal.GoalResponse;
import ru.akvine.prorise.rest.dto.goal.GoalUpdateRequest;
import ru.akvine.prorise.service.dto.goal.GoalBean;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GoalConverter {
    public GoalBean convertToGoalBean(GoalCreateRequest request) {
        Preconditions.checkNotNull(request, "goalCreateRequest is null");
        return new GoalBean()
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDone(request.isDone())
                .setProjectUuid(request.getProjectUuid());
    }

    public GoalBean convertToGoalBean(GoalUpdateRequest request) {
        Preconditions.checkNotNull(request, "goalUpdateRequest is null");
        return new GoalBean()
                .setUuid(request.getUuid())
                .setTitle(request.getTitle())
                .setDescription(request.getDescription())
                .setDone(request.isDone())
                .setProjectUuid(request.getProjectUuid());
    }

    public GoalResponse convertToGoalResponse(GoalBean goalBean) {
        Preconditions.checkNotNull(goalBean, "goalBean is null");
        return new GoalResponse()
                .setTitle(goalBean.getTitle())
                .setDescription(goalBean.getDescription())
                .setDone(goalBean.isDone());
    }

    public GoalListResponse convertToGoalListResponse(List<GoalBean> goals) {
        Preconditions.checkNotNull(goals, "goals is null");
        List<GoalResponse> goalResponses = goals
                .stream()
                .map(this::convertToGoalResponse)
                .collect(Collectors.toList());
        return new GoalListResponse()
                .setGoals(goalResponses);
    }
}
