package ru.akvine.prorise.rest.validator;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.exceptions.ValidationException;
import ru.akvine.prorise.rest.dto.kpi.GetKPIRequest;

import java.time.LocalDateTime;

@Component
public class KPIValidator {
    public void verify(GetKPIRequest request) {
        Preconditions.checkNotNull(request, "getKPIRequest is null");

        LocalDateTime startDate = request.getStartDate();
        LocalDateTime endDate = request.getEndDate();
        if (startDate != null && endDate != null) {
            if (startDate.isAfter(endDate)) {
                throw new ValidationException("Incorrect date range for: " + startDate + " and " + endDate);
            }
        }
    }
}
