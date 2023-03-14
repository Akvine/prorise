package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.converter.GoalConverter;
import ru.akvine.prorise.rest.validator.GoalValidator;
import ru.akvine.prorise.service.GoalService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/goals")
public class GoalController {
    private final GoalValidator goalValidator;
    private final GoalService goalService;
    private final GoalConverter goalConverter;

}
