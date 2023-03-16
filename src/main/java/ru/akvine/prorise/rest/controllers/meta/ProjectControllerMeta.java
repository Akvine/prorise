package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.*;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.project.ProjectCreateRequest;
import ru.akvine.prorise.rest.dto.project.ProjectUpdateRequest;

import javax.validation.Valid;

@RequestMapping(value = "/projects")
public interface ProjectControllerMeta {
    @GetMapping
    Response get();

    @GetMapping("/{uuid}")
    Response getByUuid(@PathVariable("uuid") String uuid);

    @PostMapping
    Response create(@RequestBody @Valid ProjectCreateRequest request);

    @PutMapping
    Response update(@RequestBody @Valid ProjectUpdateRequest request);

    @DeleteMapping("/{uuid}")
    Response deleteByUuid(@PathVariable("uuid") String uuid);
}
