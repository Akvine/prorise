package ru.akvine.prorise.service.dto.attendance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.akvine.prorise.entities.employer.AttendanceEntity;
import ru.akvine.prorise.service.dto.employer.EmployerBean;

import java.time.LocalDateTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class AttendanceBean {
    private Long id;
    private String employerUuid;
    private EmployerBean employerBean;
    private LocalDateTime arrivalDate;
    private LocalDateTime departureTime;

    public AttendanceBean(AttendanceEntity attendanceEntity) {
        this.id = attendanceEntity.getId();
        this.employerBean = new EmployerBean(attendanceEntity.getEmployer());
        this.arrivalDate = attendanceEntity.getArrivalTime();
        this.departureTime = attendanceEntity.getDepartureTime();
    }
}
