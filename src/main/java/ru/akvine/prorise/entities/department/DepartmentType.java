package ru.akvine.prorise.entities.department;

public enum DepartmentType {
    FINANCIAL,
    IT,
    LOGISTIC,
    LEGAL,
    PURCHASING,
    PRODUCTION,
    SALES,
    MARKETING,
    HR,
    OTHER;

    public static DepartmentType safeValueOf(String type) {
        String toUpperType = type.toUpperCase();
        switch (toUpperType) {
            case "FINANCIAL":
                return FINANCIAL;
            case "IT":
                return IT;
            case "LOGISTIC":
                return LOGISTIC;
            case "LEGAL":
                return LEGAL;
            case "PURCHASING":
                return PURCHASING;
            case "PRODUCTION":
                return PRODUCTION;
            case "SALES":
                return SALES;
            case "MARKETING":
                return MARKETING;
            case "HR":
                return HR;
            default:
                return OTHER;
        }
    }
}
