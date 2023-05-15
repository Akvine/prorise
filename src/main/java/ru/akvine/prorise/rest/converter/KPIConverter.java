package ru.akvine.prorise.rest.converter;

import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;
import ru.akvine.prorise.rest.dto.kpi.GetKPIRequest;
import ru.akvine.prorise.rest.dto.kpi.GetKPIResponse;
import ru.akvine.prorise.service.dto.kpi.KPIStatistics;
import ru.akvine.prorise.service.dto.kpi.KPIStatisticsFilter;
import ru.akvine.prorise.service.dto.kpi.filter.DepartmentFilter;
import ru.akvine.prorise.service.dto.kpi.filter.EmployerFilter;
import ru.akvine.prorise.service.dto.kpi.filter.FilterType;
import ru.akvine.prorise.service.dto.kpi.filter.TeamFilter;

@Component
public class KPIConverter {
    public KPIStatisticsFilter convertToKPIStatisticsStart(GetKPIRequest getKPIRequest) {
        Preconditions.checkNotNull(getKPIRequest, "getKPIRequest is null");
        return buildKPIStatisticsStart(getKPIRequest);
    }

    public GetKPIResponse convertToGetKPIResponse(KPIStatistics kpiStatistics) {
        Preconditions.checkNotNull(kpiStatistics, "kpiStatistics is null");
        return new GetKPIResponse()
                .setKpiStatistics(kpiStatistics);
    }

    private KPIStatisticsFilter buildKPIStatisticsStart(GetKPIRequest request) {
        FilterType filterType = FilterType.safeValueOf(request.getFilterType());
        switch (filterType) {
            case DEPARTMENT:
                String departmentTitle = request.getKpiFilter().getDepartment() == null ? null : request.getKpiFilter().getDepartment().getTitle();
                String departmentType = request.getKpiFilter().getDepartment() == null ? null : request.getKpiFilter().getDepartment().getType();
                return new KPIStatisticsFilter()
                        .setFilterType(filterType)
                        .setDepartmentFilter(new DepartmentFilter(departmentTitle, departmentType));
            case TEAM:
                String teamTitle = request.getKpiFilter().getTeam() == null ? null : request.getKpiFilter().getTeam().getTitle();
                return new KPIStatisticsFilter()
                        .setFilterType(filterType)
                        .setTeamFilter(new TeamFilter(teamTitle));
            case EMPLOYER:
                String uuid = request.getKpiFilter().getEmployer() == null ? null : request.getKpiFilter().getEmployer().getUuid();
                String firstName = request.getKpiFilter().getEmployer() == null ? null : request.getKpiFilter().getEmployer().getFirstName();
                String secondName = request.getKpiFilter().getEmployer() == null ? null : request.getKpiFilter().getEmployer().getSecondName();
                String thirdName = request.getKpiFilter().getEmployer() == null ? null : request.getKpiFilter().getEmployer().getThirdName();
                return new KPIStatisticsFilter()
                        .setFilterType(filterType)
                        .setEmployerFilter(new EmployerFilter(uuid, firstName, secondName, thirdName));
            default:
                throw new IllegalArgumentException("Filter type =" + filterType.name() + " not supported");
        }
    }
}
