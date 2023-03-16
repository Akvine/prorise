package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.*;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.department.DepartmentCreateRequest;
import ru.akvine.prorise.rest.dto.department.DepartmentUpdateRequest;

import javax.validation.Valid;

@RequestMapping(value = "/departments")
public interface DepartmentControllerMeta {
    @GetMapping
    Response get();

    @GetMapping("/{uuid}")
    Response getByUuid(@PathVariable("uuid") String uuid);

    @PostMapping
    Response create(@RequestBody @Valid DepartmentCreateRequest request);

    @PutMapping
    Response update(@RequestBody @Valid DepartmentUpdateRequest request);

    @DeleteMapping("/{uuid}")
    Response deleteByUuid(@PathVariable("uuid") String uuid);
}
