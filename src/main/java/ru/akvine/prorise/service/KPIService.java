package ru.akvine.prorise.service;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.akvine.prorise.service.dto.employer.EmployerBean;
import ru.akvine.prorise.service.dto.kpi.KPI;
import ru.akvine.prorise.service.dto.kpi.KPIResult;

@Service
@RequiredArgsConstructor
public class KPIService {
    private final EmployerService employerService;
    private final TaskService taskService;

    public KPIResult getKPI(KPI kpi) {
        Preconditions.checkNotNull(kpi, "kpi is null");

//        EmployerBean employer = employerService.getByUuid(kpi.getEmployerUuid());
        Integer completedTasks = taskService.getCompletedTask().size();
        return new KPIResult()
                .setCompletedTasks(15);
    }
}
