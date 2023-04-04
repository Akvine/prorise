package ru.akvine.prorise.rest.validator;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.exceptions.KPIFilterNotFoundException;
import ru.akvine.prorise.rest.dto.kpi.GetKPIRequest;

import java.util.List;

@Component
public class KPIValidator {
    private static final List<String> AVAILABLE_KPI_FILTERS = List.of("COMPLETED_TASKS");

    public void verifyGetKPIRequest(GetKPIRequest request) {
        Preconditions.checkNotNull(request, "getKPIRequest is null");

        List<String> filters = request.getFilters();
        filters
                .forEach(filter -> {
                    if (!AVAILABLE_KPI_FILTERS.contains(filter)) {
                        throw new KPIFilterNotFoundException("Filter = " + filter + " not exists");
                    }
                });
    }
}
