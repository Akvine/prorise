package ru.akvine.prorise.service.dto.attendance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceStatistics {
    private LocalTime averageArrivalTime;
    private LocalTime averageDepartureTime;
    private LocalTime averageWorkTime;
}
