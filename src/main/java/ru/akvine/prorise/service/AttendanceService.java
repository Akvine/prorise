package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.entities.employer.AttendanceEntity;
import ru.akvine.prorise.entities.employer.EmployerEntity;
import ru.akvine.prorise.repositories.AttendanceRepository;
import ru.akvine.prorise.service.dto.attendance.AttendanceBean;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final EmployerService employerService;
    private final AttendanceRepository attendanceRepository;

    public AttendanceBean create(AttendanceBean attendanceBean) {
        Preconditions.checkNotNull(attendanceBean, "attendanceBean is null");
        Preconditions.checkNotNull(attendanceBean.getEmployerUuid(), "attendanceBean.employerUuid is null");

        String employerUuid = attendanceBean.getEmployerUuid();
        EmployerEntity employerEntity = employerService.getEntityByUuid(employerUuid);

        AttendanceEntity attendanceEntity = new AttendanceEntity()
                .setEmployerEntity(employerEntity)
                .setDepartureTime(attendanceBean.getDepartureTime())
                .setArrivalTime(attendanceBean.getArrivalDate());
        AttendanceEntity createdAttendanceEntity = attendanceRepository.save(attendanceEntity);
        return new AttendanceBean(createdAttendanceEntity);
    }
}
