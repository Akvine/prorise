package ru.akvine.prorise.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.akvine.prorise.rest.controllers.meta.AttendanceControllerMeta;
import ru.akvine.prorise.rest.converter.AttendanceConverter;
import ru.akvine.prorise.rest.dto.attendance.AttendanceCreateRequest;
import ru.akvine.prorise.rest.dto.common.Response;
import ru.akvine.prorise.rest.dto.common.SuccessfulResponse;
import ru.akvine.prorise.service.AttendanceService;
import ru.akvine.prorise.service.dto.attendance.AttendanceBean;

@RestController
@RequiredArgsConstructor
public class AttendanceController implements AttendanceControllerMeta {
    private final AttendanceConverter attendanceConverter;
    private final AttendanceService attendanceService;

    @Override
    public Response create(AttendanceCreateRequest request) {
        AttendanceBean attendanceBean = attendanceConverter.convertToEmployerAttendanceBean(request);
        attendanceService.create(attendanceBean);
        return new SuccessfulResponse();
    }
}
