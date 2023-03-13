package ru.akvine.prorise.entities.employer;

public enum EmployerType {
    LEAD,
    COUCH,
    ANALYST,
    HR,
    RESOURCE_OFFICER,
    WORKER;

    public static EmployerType safeValueOf(String value) {
        switch (value.toUpperCase()) {
            case "LEAD": return EmployerType.LEAD;
            case "COUCH": return EmployerType.COUCH;
            case "ANALYST": return EmployerType.ANALYST;
            case "HR": return EmployerType.HR;
            case "RESOURCE_OFFICER": return EmployerType.RESOURCE_OFFICER;
            case "WORKER": return EmployerType.WORKER;
            default: throw new IllegalArgumentException("Illegal employer type");
        }
    }
}
