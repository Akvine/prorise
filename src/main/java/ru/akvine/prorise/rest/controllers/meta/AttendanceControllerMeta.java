package ru.akvine.prorise.rest.controllers.meta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.akvine.prorise.rest.dto.attendance.AttendanceCreateRequest;
import ru.akvine.prorise.rest.dto.common.Response;

import javax.validation.Valid;

@RequestMapping(value = "/attendances")
public interface AttendanceControllerMeta {
    @PostMapping
    Response create(@RequestBody @Valid AttendanceCreateRequest request);
}
