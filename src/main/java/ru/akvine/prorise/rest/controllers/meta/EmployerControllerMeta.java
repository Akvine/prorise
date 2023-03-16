package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.*;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.employer.EmployerCreateRequest;
import ru.akvine.prorise.rest.dto.employer.EmployerUpdateRequest;

import javax.validation.Valid;

@RequestMapping(value = "/employers")
public interface EmployerControllerMeta {
    @GetMapping
    Response get();

    @GetMapping("/{uuid}")
    Response getByUuid(@PathVariable("uuid") String uuid);

    @PostMapping
    Response create(@RequestBody @Valid EmployerCreateRequest request);

    @PutMapping
    Response update(@RequestBody @Valid EmployerUpdateRequest request);

    @DeleteMapping("/{uuid}")
    Response delete(@PathVariable("uuid") String uuid);
}
