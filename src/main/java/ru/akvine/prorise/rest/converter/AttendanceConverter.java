package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.attendance.AttendanceCreateRequest;
import ru.akvine.prorise.service.dto.attendance.AttendanceBean;

@Component
public class AttendanceConverter {
    public AttendanceBean convertToEmployerAttendanceBean(AttendanceCreateRequest request) {
        Preconditions.checkNotNull(request, "attendanceCreateRequest is null");
        return new AttendanceBean()
                .setEmployerUuid(request.getEmployerUuid())
                .setArrivalDate(request.getArrivalTime())
                .setDepartureTime(request.getDepartureTime());
    }
}
