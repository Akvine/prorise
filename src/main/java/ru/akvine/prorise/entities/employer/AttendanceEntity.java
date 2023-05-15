package ru.akvine.prorise.entities.employer;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ATTENDANCE")
@Accessors(chain = true)
@Data
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendanceSeq")
    @SequenceGenerator(name = "attendanceSeq", sequenceName = "ATTENDANCE_SEQUENCE", allocationSize = 1000)
    private Long id;

    @Column(name = "ARRIVAL_TIME")
    private LocalDateTime arrivalTime;

    @Column(name = "DEPARTURE_TIME")
    private LocalDateTime departureTime;

    @ManyToOne
    @JoinColumn(name = "EMPLOYER_ID", nullable = false)
    private EmployerEntity employer;
}
