package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.*;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.goal.GoalCreateRequest;
import ru.akvine.prorise.rest.dto.goal.GoalUpdateRequest;

import javax.validation.Valid;

@RequestMapping(value = "/goals")
public interface GoalControllerMeta {
    @GetMapping
    Response get();

    @GetMapping("/{uuid}")
    Response getByUuid(@PathVariable("uuid") String uuid);

    @PostMapping
    Response create(@RequestBody @Valid GoalCreateRequest request);

    @PutMapping
    Response update(@RequestBody @Valid GoalUpdateRequest request);

    @DeleteMapping("/{uuid}")
    Response deleteByUuid(@PathVariable("uuid") String uuid);
}
