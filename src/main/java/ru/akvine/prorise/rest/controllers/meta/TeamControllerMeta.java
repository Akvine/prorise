package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.*;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.team.TeamCreateRequest;
import ru.akvine.prorise.rest.dto.team.TeamUpdateRequest;

import javax.validation.Valid;

@RequestMapping(value = "/teams")
public interface TeamControllerMeta {
    @GetMapping
    Response get();

    @GetMapping("/{uuid}")
    Response getByUuid(@PathVariable("uuid") String uuid);

    @PostMapping
    Response create(@RequestBody @Valid TeamCreateRequest request);

    @PutMapping
    Response update(@RequestBody @Valid TeamUpdateRequest request);

    @DeleteMapping("/{uuid}")
    Response deleteByUuid(@PathVariable("uuid") String uuid);
}
