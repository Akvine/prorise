package ru.akvine.prorise.service.dto.kpi.filter;

public enum FilterType {
    DEPARTMENT,
    TEAM,
    EMPLOYER;

    public static FilterType safeValueOf(String type) {
        String toUpperType = type.toUpperCase();
        switch (toUpperType) {
            case "DEPARTMENT":
                return DEPARTMENT;
            case "TEAM":
                return TEAM;
            case "EMPLOYER":
                return EMPLOYER;
            default:
                throw new IllegalArgumentException("Illegal argument = " + type + " for kpi filtering");
        }
    }
}
