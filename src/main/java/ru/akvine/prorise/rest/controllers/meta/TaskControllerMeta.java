package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.*;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.task.TaskCreateRequest;
import ru.akvine.prorise.rest.dto.task.TaskUpdateRequest;

import javax.validation.Valid;

@RequestMapping(value = "/tasks")
public interface TaskControllerMeta {
    @GetMapping
    Response get();

    @GetMapping("/{uuid}")
    Response getByUuid(@PathVariable("uuid") String uuid);

    @PostMapping
    Response create(@RequestBody @Valid TaskCreateRequest request);

    @PutMapping
    Response update(@RequestBody @Valid TaskUpdateRequest request);

    @DeleteMapping("/{uuid}")
    Response deleteByUuid(@PathVariable("uuid") String uuid);
}
